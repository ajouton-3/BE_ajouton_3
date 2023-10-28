package com.ajouton.noname.domain.plan.service;

import com.ajouton.noname.domain.plan.repository.PlanRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class PlanService {

    private final PlanRepository planRepository;

}
