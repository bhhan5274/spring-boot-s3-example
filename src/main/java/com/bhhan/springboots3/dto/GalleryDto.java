package com.bhhan.springboots3.dto;

import com.bhhan.springboots3.domain.Gallery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by hbh5274@gmail.com on 2020-08-02
 * Github : http://github.com/bhhan5274
 */

@Getter
@Setter
@NoArgsConstructor
public class GalleryDto {
    private Long id;
    private String originalName;
    private String filePath;

    @Builder
    public GalleryDto(Gallery gallery){
        this.id = gallery.getId();
        this.originalName = gallery.getOriginalName();
        this.filePath = gallery.getFilePath();
    }
}
