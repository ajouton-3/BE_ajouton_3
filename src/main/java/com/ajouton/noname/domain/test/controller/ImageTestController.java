package com.ajouton.noname.domain.test.controller;

import com.ajouton.noname.domain.test.entity.ImageTest;
import com.ajouton.noname.domain.test.service.ImageTestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/test")
@RestController
@Slf4j
public class ImageTestController {

    private final ImageTestService imageTestService;

    @PostMapping("/upload")
    public ResponseEntity<String> testUploadImage(@RequestPart("images") List<MultipartFile> images) {
        ImageTest imageTest = imageTestService.uploadImage(images);
        return ResponseEntity.ok(imageTest.getUrl());
    }
}
