package com.bhkim.querydsl.repository;

import com.bhkim.querydsl.dto.MemberCondition;
import com.bhkim.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberJpaCustom {
    List<MemberTeamDto> searchByBuilder(MemberCondition condition);
}

