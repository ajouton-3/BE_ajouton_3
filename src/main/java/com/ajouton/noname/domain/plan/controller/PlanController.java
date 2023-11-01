package com.ajouton.noname.domain.plan.controller;

import com.ajouton.noname.domain.plan.dto.PlanListResponse;
import com.ajouton.noname.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    @GetMapping("/calendar/{userId}")
    public ResponseEntity<List<PlanListResponse>> calender(@PathVariable Long userId){
        List<PlanListResponse> calender = planService.calender(userId);

        return new ResponseEntity<>(calender, HttpStatus.OK);
    }

}
