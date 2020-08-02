package com.bhhan.springboots3.web;

import com.bhhan.springboots3.service.GalleryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by hbh5274@gmail.com on 2020-08-02
 * Github : http://github.com/bhhan5274
 */

@RequiredArgsConstructor
@Controller
public class GalleryController {
    private final GalleryService galleryService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("galleryList", galleryService.galleries());

        return "gallery";
    }

    @PostMapping("/gallery")
    public String upload(MultipartFile file) {
        galleryService.saveGallery(file);

        return "redirect:/";
    }
}
