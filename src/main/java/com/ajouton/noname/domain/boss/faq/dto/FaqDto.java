package com.ajouton.noname.domain.boss.faq.dto;

import com.ajouton.noname.domain.faq.entity.Faq;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FaqDto {
  private String question;
  private String answer;

  public FaqDto(Faq faq) {
    this.question = faq.getQuestion();
    this.answer = faq.getAnswer();
  }
}
