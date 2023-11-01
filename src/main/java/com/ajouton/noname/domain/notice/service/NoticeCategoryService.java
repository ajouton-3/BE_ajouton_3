package com.ajouton.noname.domain.notice.service;

import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.notice.entity.NoticeCategory;
import com.ajouton.noname.domain.notice.repository.NoticeCategoryRepository;
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
public class NoticeCategoryService {

    private final NoticeCategoryRepository noticeCategoryRepository;

    public void createNoticeCategory(String noticeCategoryName){
        //TODO: 이미 중복되는 값이 있는지 확인

        NoticeCategory noticeCategory = NoticeCategory.builder()
                .noticeCategory(noticeCategoryName)
                .build();
        noticeCategoryRepository.save(noticeCategory);
    }

    public void deleteNoticeCategory(String noticeCategoryName){
        NoticeCategory noticeCategory = noticeCategoryRepository.findById(noticeCategoryName)
                .orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));
        noticeCategoryRepository.delete(noticeCategory);
    }

    public List<String> showAllNoticeCategory(){
        List<String> result = new ArrayList<>();
        List<NoticeCategory> all = noticeCategoryRepository.findAll();
        for(NoticeCategory noticeCategory:all){
            result.add(noticeCategory.getNoticeCategory());
        }
        return result;
    }
}
