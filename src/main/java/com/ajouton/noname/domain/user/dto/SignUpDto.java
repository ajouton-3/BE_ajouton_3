package com.ajouton.noname.domain.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SignUpDto {
  private String username;
  private String password;
  private String studentId;
  private String phoneNum;
  private String department;
}