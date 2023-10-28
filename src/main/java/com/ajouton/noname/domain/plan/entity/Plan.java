package com.ajouton.noname.domain.plan.entity;

import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plan extends BaseTimeEntity {

    @Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="club_id")
    private Club club;

    @Column(length = 100,nullable = false)
    private String content;

    @Column(nullable = false,name="start_date")
    private LocalDateTime startDate;

    @Column(nullable = false,name="end_date")
    private LocalDateTime endDate;

}
