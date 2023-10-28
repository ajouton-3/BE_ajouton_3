package com.ajouton.noname.domain.member.entity;

import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_num",nullable = false)
    private String phoneNum;

    @Column(name="student_id",nullable = false)
    private String studentId;

    @Column(name="department",nullable = false)
    private String department;


    @Builder
    private Member(final String name,
                   final String phoneNum,
                   final String studentId,
                   final String department){
        this.name=name;
        this.phoneNum=phoneNum;
        this.studentId=studentId;
        this.department = department;
    }
}
