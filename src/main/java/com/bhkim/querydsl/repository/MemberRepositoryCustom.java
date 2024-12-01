package com.bhkim.querydsl.repository;

import com.bhkim.querydsl.dto.MemberSearchCondition;
import com.bhkim.querydsl.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> searchByBuilder(MemberSearchCondition condition);

    List<MemberTeamDto> search(MemberSearchCondition condition);

    // 쿼리 하나로 paging 처리
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable page);
}

