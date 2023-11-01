package com.ajouton.noname.domain.club.dto;

import com.ajouton.noname.domain.club.entity.Club;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClubDto {
  private Long clubId;
  private String name;
  private String logo;
  private String description;
  private char isRecruit;

  public ClubDto(Club club) {
    this.clubId = club.getClubId();
    this.name = club.getClubName();
    this.logo = club.getLogo();
    this.description = club.getDescription();
    this.isRecruit = club.getIsRecruit();
  }
}
