package com.ajouton.noname.domain.user.dto;

import com.ajouton.noname.domain.user.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfoResponseDto {
  private Long userId;
  private String username;
  private String studentId;
  private String phoneNum;
  private String department;

  public UserInfoResponseDto(User user) {
    this.userId = user.getUserId();
    this.username = user.getName();
    this.studentId = user.getStudentId();
    this.phoneNum = user.getPhoneNum();
    this.department = user.getDepartment();
  }
}