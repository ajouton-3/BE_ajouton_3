package com.ajouton.noname.domain.faq.entity;

import com.ajouton.noname.domain.club.entity.Club;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="faq_id",nullable = false)
    private int faqId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;

    @Column(length = 200, nullable = false)
    private String question;

    @Column(length = 200, nullable = false)
    private String answer;

    @Builder
    private Faq(final Club club, final String question, final String answer) {
        this.club=club;
        this.question=question;
        this.answer = answer;
    }

}
