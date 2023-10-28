package com.ajouton.noname.domain.plan.service;

import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubMemberService;
import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.plan.dto.PlanListResponse;
import com.ajouton.noname.domain.plan.entity.Plan;
import com.ajouton.noname.domain.plan.repository.PlanRepository;
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
public class PlanService {

    private final PlanRepository planRepository;
    private final ClubMemberService clubMemberService;
    private final ClubService clubService;

    public List<PlanListResponse> calender(Long userId){
        List<Long> allClubIdsByUserId = clubMemberService.findAllClubIdsByUserId(userId);
        List<PlanListResponse> planListResponses = new ArrayList<>();

        for(Long clubId:allClubIdsByUserId) {

            Club club = clubService.findById(clubId);
            List<Plan> plans = planRepository.findAllByClub(club);

            for (Plan plan : plans) {
                if (plan != null) {
                    planListResponses.add(PlanListResponse.builder()
                            .planId(plan.getPlanId())
                            .clubId(clubId)
                            .content(plan.getContent())
                            .startDate(plan.getStartDate())
                            .endDate(plan.getEndDate())
                            .build());
                }
            }
        }

        return planListResponses;
    }

}
