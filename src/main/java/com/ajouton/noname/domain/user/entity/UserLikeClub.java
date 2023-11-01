package com.ajouton.noname.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@IdClass(LikeClubId.class)
@Table(name = "user_like_club")
public class UserLikeClub {
  @Id
  @Column(name = "club_id")
  private Long clubId;

  @Id
  @Column(name = "user_id")
  private Long userId;
}
