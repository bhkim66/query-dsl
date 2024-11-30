package com.bhkim.querydsl.repository;

import com.bhkim.querydsl.dto.MemberSearchCondition;
import com.bhkim.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberJpaCustom {
    List<MemberTeamDto> searchByBuilder(MemberSearchCondition condition);

    List<MemberTeamDto> searchByWhereParameter(MemberSearchCondition condition);
}

