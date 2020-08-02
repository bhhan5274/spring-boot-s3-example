package com.bhhan.springboots3.service;

import com.bhhan.springboots3.domain.Gallery;
import com.bhhan.springboots3.domain.GalleryRepository;
import com.bhhan.springboots3.dto.GalleryDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by hbh5274@gmail.com on 2020-08-02
 * Github : http://github.com/bhhan5274
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class GalleryService {
    @Value("${cloud.aws.cloudFront.url}")
    private String cloudFrontUrl;

    private static final String DEFAULT_DIR = "bhhan";
    private final GalleryRepository galleryRepository;
    private final S3Uploader s3Uploader;

    public List<GalleryDto> galleries(){
        return galleryRepository.findAll()
                .stream()
                .map(GalleryDto::new)
                .collect(Collectors.toList());
    }

    public void saveGallery(MultipartFile file){
        try{
            ifCashingIsDelete(file);
            final String url = s3Uploader.upload(file, DEFAULT_DIR);
            galleryRepository.save(Gallery.builder()
                    .originalName(file.getOriginalFilename())
                    .key(url)
                    .filePath(cloudFrontUrl + "/" + url)
                    .build());
        }catch(Exception e){
            throw new IllegalArgumentException("Gallery 추가 실패!!!");
        }
    }

    private void ifCashingIsDelete(MultipartFile file){
        galleryRepository.findByOriginalName(file.getOriginalFilename())
                .ifPresent(gallery -> {
                    s3Uploader.delete(gallery.getKey());
                    galleryRepository.deleteById(gallery.getId());
                });
    }
}
