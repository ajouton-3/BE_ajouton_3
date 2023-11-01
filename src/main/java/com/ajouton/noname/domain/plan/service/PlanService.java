package com.ajouton.noname.domain.plan.service;

import com.ajouton.noname.domain.boss.plan.dto.CreatePlanRequest;
import com.ajouton.noname.domain.boss.plan.dto.PlanListFromOneClubResponse;
import com.ajouton.noname.domain.club.entity.Club;
import com.ajouton.noname.domain.club.service.ClubMemberService;
import com.ajouton.noname.domain.club.service.ClubService;
import com.ajouton.noname.domain.exception.CustomException;
import com.ajouton.noname.domain.exception.ErrorCode;
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
            log.info(Long.toString(clubId));
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

    public void createPlan(CreatePlanRequest createPlanRequest){
        Club club = clubService.findById(createPlanRequest.clubId());
        Plan newPlan = Plan.builder()
                .startDate(createPlanRequest.startDate())
                .content(createPlanRequest.content())
                .endDate(createPlanRequest.endDate())
                .club(club)
                .build();
        planRepository.save(newPlan);

    }

    public void deletePlan(int planId){
        Plan plan = planRepository.findById(planId).orElseThrow(() -> new CustomException(ErrorCode.ERROR_1));
        planRepository.delete(plan);
    }

    public List<PlanListResponse> showPlanList(Long clubId){

        Club club = clubService.findById(clubId);
        List<Plan> allByClub = planRepository.findAllByClub(club);

        List<PlanListResponse> result = new ArrayList<>();
        for(Plan plan:allByClub){
            PlanListResponse build = PlanListResponse.builder()
                    .planId(plan.getPlanId())
                    .clubId(clubId)
                    .content(plan.getContent())
                    .startDate(plan.getStartDate())
                    .endDate(plan.getEndDate())
                    .build();
            result.add(build);
        }
        return result;
    }

}
