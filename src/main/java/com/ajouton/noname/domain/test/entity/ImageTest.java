package com.ajouton.noname.domain.test.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.awt.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter

public class ImageTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;
    @Builder
    private ImageTest(final String url){
        this.url = url;

    }

}
