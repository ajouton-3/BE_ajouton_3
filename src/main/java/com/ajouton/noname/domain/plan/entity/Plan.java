package com.ajouton.noname.domain.plan.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "PLANS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Plan {

    @Id
    @Column(name = "plan_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int planId;

    @Column(length = 100,nullable = false)
    private String content;

    @Column(nullable = false,name="start_date")
    private LocalDateTime startDate;

    @Column(nullable = false,name="end_date")
    private LocalDateTime endDate;

}
