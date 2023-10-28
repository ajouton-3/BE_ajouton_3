package com.ajouton.noname.domain.member.controller;


import com.ajouton.noname.domain.member.entity.Member;
import com.ajouton.noname.domain.member.dto.CreateMemberRequest;
import com.ajouton.noname.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/members")
@RestController
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/join")
    public ResponseEntity<String> join(CreateMemberRequest createMemberRequest){
        memberService.join(createMemberRequest);
        return ResponseEntity.ok("회원가입 완료");
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<Member> showMember(@PathVariable Long id){
        Member member = memberService.showMemberById(id);
        return ResponseEntity.ok(member);
    }
}
