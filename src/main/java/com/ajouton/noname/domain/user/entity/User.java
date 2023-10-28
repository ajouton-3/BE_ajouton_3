package com.ajouton.noname.domain.user.entity;

import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id",nullable = false)
    private Long userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name="name",nullable = false)
    private String name;

    @Column(name="phone_num",nullable = false, length = 13)
    private String phoneNum;

    @Column(name="student_id",nullable = false, length = 9)
    private String studentId;

    @Column(name="department",nullable = false)
    private String department;
}
