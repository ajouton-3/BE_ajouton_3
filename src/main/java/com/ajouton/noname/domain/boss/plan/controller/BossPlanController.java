package com.ajouton.noname.domain.boss.plan.controller;

import com.ajouton.noname.domain.boss.notice.dto.CreateNoticeRequest;
import com.ajouton.noname.domain.boss.plan.dto.CreatePlanRequest;
import com.ajouton.noname.domain.boss.plan.dto.PlanListFromOneClubResponse;
import com.ajouton.noname.domain.plan.dto.PlanListResponse;
import com.ajouton.noname.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/boss/plans")
public class BossPlanController {

    private final PlanService planService;

    @PostMapping("")
    public ResponseEntity createPlan(CreatePlanRequest createPlanRequest){
        planService.createPlan(createPlanRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{planId}")
    public ResponseEntity deletePlan(@PathVariable int planId){
        planService.deletePlan(planId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all/{clubId}")
    public ResponseEntity<List<PlanListResponse>> showPlanList(@PathVariable Long clubId){
        List<PlanListResponse> planListResponses = planService.showPlanList(clubId);
        return new ResponseEntity<>(planListResponses, HttpStatus.OK);

    }
}
