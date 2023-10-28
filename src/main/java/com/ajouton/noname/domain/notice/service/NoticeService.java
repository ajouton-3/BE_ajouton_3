package com.ajouton.noname.domain.notice.service;

import com.ajouton.noname.domain.activity.dto.ActivityInfoResponse;
import com.ajouton.noname.domain.activity.dto.ActivityListResponse;
import com.ajouton.noname.domain.activity.entity.Activity;
import com.ajouton.noname.domain.activity.repository.ActivityRepository;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
import com.ajouton.noname.domain.notice.dto.NoticeInfoResponse;
import com.ajouton.noname.domain.notice.dto.NoticeListResponse;
import com.ajouton.noname.domain.notice.entity.Notice;
import com.ajouton.noname.domain.notice.repository.NoticeRepository;
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
public class NoticeService {

    private final NoticeRepository noticeRepository;

    public List<NoticeListResponse> showNoticeList(Club club){
        List<NoticeListResponse> results = new ArrayList<>();

        List<Notice> noticeList = noticeRepository.findAllByClub(club);

        for(Notice notice:noticeList){
            results.add(NoticeListResponse.builder()
                    .noticeId(notice.getNoteId())
                    .noticeCategory(notice.getNoticeCategory().getNoticeCategory())
                    .title(notice.getTitle())
                    .createdAt(notice.getCreatedAt())
                    .build());
        }
        return results;

    }

    public NoticeInfoResponse showNoticeInfo(int noticeId){
        Notice notice = noticeRepository.findById(noticeId).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));

        NoticeInfoResponse noticeInfoResponse = NoticeInfoResponse.builder()
                .image(notice.getImage())
                .title(notice.getTitle())
                .content(notice.getContent())
                .createdAt(notice.getCreatedAt())
                .updateAt(notice.getUpdatedAt())
                .build();

        return noticeInfoResponse;
    }
}
