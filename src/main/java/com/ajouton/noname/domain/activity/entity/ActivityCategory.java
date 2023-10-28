package com.ajouton.noname.domain.activity.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="ACTIVITY_CATEGORIES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ActivityCategory {
    @Id
    @Column(name="activity_category",length = 10)
    private String activityCategory;


    @Builder
    private ActivityCategory(String activityCategory){
        this.activityCategory = activityCategory;
    }
}
