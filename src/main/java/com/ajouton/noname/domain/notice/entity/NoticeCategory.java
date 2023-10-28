package com.ajouton.noname.domain.notice.entity;


import com.ajouton.noname.domain.activity.entity.ActivityCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="NOTICE_CATEGORIES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoticeCategory {

    @Id
    @Column(name = "notice_category",length = 10)
    private String noticeCategory;



}
