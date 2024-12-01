package com.bhkim.querydsl.controller;

import com.bhkim.querydsl.dto.MemberSearchCondition;
import com.bhkim.querydsl.dto.MemberTeamDto;
import com.bhkim.querydsl.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberRepository.search(condition);
    }
}
