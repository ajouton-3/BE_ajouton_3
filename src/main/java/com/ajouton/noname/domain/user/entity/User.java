package com.ajouton.noname.domain.user.entity;

import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "USERS")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_num",nullable = false)
    private String phoneNum;

    @Column(name="stuend_id",nullable = false)
    private String studentId;

    @Column(name="department",nullable = false)
    private String department;


    @Builder
    private User(final String name,
                   final String phoneNum,
                   final String studentId,
                   final String department){
        this.name=name;
        this.phoneNum=phoneNum;
        this.studentId=studentId;
        this.department = department;
    }
}
