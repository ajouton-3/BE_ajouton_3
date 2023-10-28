package com.ajouton.noname.domain.club.entity;

import com.ajouton.noname.domain.activity.entity.ActivityCategory;
import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name="CLUBS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Club extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_category")
    private ClubCategory clubCategory;

    @Column(name = "club_name", length = 20, nullable = false)
    private String clubName;

    @Column(length = 100, nullable = false)
    private String logo;

    @Column(length = 50)
    private String description;

    @Column(length = 50)
    private String target;

    private int fee;

    @Column(length = 13,nullable = false)
    private String contact;

    @Column(name = "activity_expired", nullable = false)
    private LocalDateTime activityExpired;

    private boolean isRecruit;



    @Builder
    private Club(final String clubName,
                 final String logo,
                 final String description,
                 final String target,
                 final int fee,
                 final String contact,
                 final LocalDateTime activityExpired,
                 final boolean isRecruit,
                 final ClubCategory clubCategory) {

        this.clubName=clubName;
        this.logo=logo;
        this.description=description;
        this.target = target;
        this.fee=fee;
        this.contact=contact;
        this.activityExpired=activityExpired;
        this.isRecruit=isRecruit;
        this.clubCategory = clubCategory;

    }
}
