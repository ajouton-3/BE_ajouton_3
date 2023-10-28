package com.ajouton.noname.domain.boss.faq.dto;

import com.ajouton.noname.domain.faq.entity.Faq;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatchFaqDto {
  private String question;
  private String answer;
}
