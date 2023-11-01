package com.ajouton.noname.domain.club.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ClubCategory {

    @Id
    @Column(name = "club_category",length = 10)
    private String clubCategory;

}
