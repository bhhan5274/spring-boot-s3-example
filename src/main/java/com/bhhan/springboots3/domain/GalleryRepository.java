package com.bhhan.springboots3.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by hbh5274@gmail.com on 2020-08-02
 * Github : http://github.com/bhhan5274
 */
public interface GalleryRepository extends JpaRepository<Gallery, Long> {
    Optional<Gallery> findByOriginalName(String originalName);
}
