package com.ajouton.noname.domain.faq.service;

import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.boss.activity.dto.ActivityDto;
import com.ajouton.noname.domain.boss.faq.dto.FaqDto;
import com.ajouton.noname.domain.boss.faq.dto.PatchFaqDto;
import com.ajouton.noname.domain.boss.faq.dto.PostFaqDto;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.repository.ClubRepository;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.faq.dto.FaqListResponse;
import com.ajouton.noname.domain.faq.entity.Faq;
import com.ajouton.noname.domain.faq.repository.FaqRepository;
import java.util.stream.Collectors;
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
    private final ClubRepository clubRepository;

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

    public void postFaq(Long clubId, PostFaqDto postFaqDto) {
        Club club = clubRepository.findById(clubId).get();
        Faq faq = Faq.builder()
            .question(postFaqDto.getQuestion())
            .answer(postFaqDto.getAnswer())
            .club(club).build();
        faqRepository.save(faq);
    }

    public List<FaqDto> getClubFaqList(Long clubId) {
        Club club = clubRepository.findById(clubId).get();
        List<Faq> faqList = faqRepository.findAllByClub(club);
        List<FaqDto> clubFaqResult = faqList.stream()
            .map(faq -> new FaqDto(faq))
            .collect(Collectors.toList());
        return clubFaqResult;
    }

    public void isValidFaq(int faqId) {
        if(!faqRepository.existsById(faqId)) {
            throw new CustomException(ErrorCode.FAQ_NOT_EXIST);
        }
    }

    public void patchFaq(int faqId, PatchFaqDto patchFaqDto) {
        Faq faq = faqRepository.findById(faqId).get();
        faq.setAnswer(patchFaqDto.getAnswer());
        faq.setQuestion(patchFaqDto.getQuestion());
    }

    public void deleteFaq(int faqId) {
        Faq faq = faqRepository.findById(faqId).get();
        faqRepository.delete(faq);
    }
}
