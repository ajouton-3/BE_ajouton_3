package com.ajouton.noname.domain.test.service;

import com.ajouton.noname.domain.s3.AmazonS3Service;
import com.ajouton.noname.domain.test.entity.ImageTest;
import com.ajouton.noname.domain.test.repository.ImageTestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class ImageTestService {

    private final ImageTestRepository imageTestRepository;
    private final AmazonS3Service amazonS3Service;

    public ImageTest uploadImage(List<MultipartFile> images){

        List<String> strings = amazonS3Service.uploadFiles(images);
        String s = strings.get(0);
        ImageTest.builder().url(s).build();
        ImageTest testImage = imageTestRepository.save(ImageTest.builder().url(s).build());

        return testImage;
    }
}
