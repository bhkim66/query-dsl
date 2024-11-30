package com.bhkim.querydsl.repository;

import com.bhkim.querydsl.dto.MemberTeamDto;
import com.bhkim.querydsl.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long>, MemberJpaCustom {

}
