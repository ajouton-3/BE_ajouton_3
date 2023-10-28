package com.ajouton.noname.domain.activity.entity;

import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "activities")
public class Activity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int activityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;

    @Column(name="image",nullable = false)
    private String image;

    @Column(name="content",length = 200,nullable = false)
    private String content;

    @Builder
    private Activity(Club club,String image,String content){
        this.club=club;
        this.image=image;
        this.content=content;
    }
}
