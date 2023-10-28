package com.ajouton.noname.domain.notice.entity;

import com.ajouton.noname.domain.club.entity.Club;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NOTICES")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Notice {
    @Id
    @Column(name = "node_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="notice_category")
    private NoticeCategory noticeCategory;

    @Column(length = 50,nullable = false)
    private String title;

    @Column(length = 200,nullable = false)
    private String content;

    private String image;



}
