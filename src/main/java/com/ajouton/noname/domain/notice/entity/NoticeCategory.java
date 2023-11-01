package com.ajouton.noname.domain.notice.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoticeCategory {

    @Id
    @Column(name = "notice_category",length = 10)
    private String noticeCategory;

    @Builder
    private NoticeCategory(String noticeCategory){
        this.noticeCategory = noticeCategory;
    }

}
