package com.ajouton.noname.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInDto {
  private String studentId;
  private String password;
}
