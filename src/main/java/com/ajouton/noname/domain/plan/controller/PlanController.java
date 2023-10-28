package com.ajouton.noname.domain.plan.controller;

import com.ajouton.noname.domain.plan.service.PlanService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

//    @GetMapping("/users/{userId}/calendar")
//    public ResponseEntity<>

}
