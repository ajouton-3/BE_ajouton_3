package com.ajouton.noname.domain.user.entity;

import com.ajouton.noname.global.entity.BaseTimeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@IdClass(MemberId.class)
@Table(name = "club_members")
public class Member extends BaseTimeEntity {
  @Id
  @Column(name = "club_id")
  private Long clubId;

  @Id
  @Column(name = "user_id")
  private Long userId;

  @Column(name="role",nullable = false)
  private String role;

  @Column(name="is_view",nullable = false, length = 1)
  private char isView = 'N';
}
