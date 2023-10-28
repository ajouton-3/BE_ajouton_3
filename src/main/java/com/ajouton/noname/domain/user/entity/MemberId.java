package com.ajouton.noname.domain.user.entity;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberId implements Serializable {

  private Long clubId;
  private Long userId;
}