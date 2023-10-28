package com.ajouton.noname.domain.user.dto;

import com.ajouton.noname.domain.user.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserClubRoleDto {
  private Long userId;
  private Long clubId;
  private String role;
}
