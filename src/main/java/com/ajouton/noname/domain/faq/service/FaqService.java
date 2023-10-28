package com.ajouton.noname.domain.faq.service;

import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.faq.dto.FaqListResponse;
import com.ajouton.noname.domain.faq.entity.Faq;
import com.ajouton.noname.domain.faq.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class FaqService {
    private final FaqRepository faqRepository;

    public List<FaqListResponse> showFaqList(Club club){
        List<FaqListResponse> results = new ArrayList<>();

        List<Faq> faqList = faqRepository.findAllByClub(club);
        for(Faq faq:faqList){

            results.add(FaqListResponse.builder()
                    .question(faq.getQuestion())
                    .answer(faq.getAnswer())
                    .build());

        }
        return results;

    }
}
