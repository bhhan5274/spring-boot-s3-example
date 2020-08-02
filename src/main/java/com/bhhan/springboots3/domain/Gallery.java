package com.bhhan.springboots3.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by hbh5274@gmail.com on 2020-08-02
 * Github : http://github.com/bhhan5274
 */

@Entity
@Table(name = "GALLERIES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Gallery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GALLERY_ID")
    private Long id;

    private String originalName;
    private String key;
    private String filePath;

    @Builder
    public Gallery(Long id, String originalName, String key, String filePath){
        this.id = id;
        this.originalName = originalName;
        this.key = key;
        this.filePath = filePath;
    }
}
