package com.bhkim.querydsl.repository;

import com.bhkim.querydsl.config.TestQueryDslConfig;
import com.bhkim.querydsl.dto.MemberSearchCondition;
import com.bhkim.querydsl.dto.MemberTeamDto;
import com.bhkim.querydsl.entity.Member;
import com.bhkim.querydsl.entity.Team;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(TestQueryDslConfig.class)
class MemberRepositoryTest {

    @Autowired
    MemberRepository repository;

    @Autowired
    EntityManager em;

    @Test
    void 멤버테스트() throws Exception {
        //given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<MemberTeamDto> memberTeamDto = repository.searchByBuilder(condition);

        assertThat(memberTeamDto).extracting("username").containsExactly("member4");

        for (MemberTeamDto teamDto : memberTeamDto) {
            System.out.println("teamDto = " + teamDto);
        }


        //when

        //then
    }

    @Test
    void 멤버_검색_테스트() throws Exception {
        System.out.println("test");
        //given
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);
        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        MemberSearchCondition condition = new MemberSearchCondition();
        condition.setAgeGoe(35);
        condition.setAgeLoe(40);
        condition.setTeamName("teamB");

        List<MemberTeamDto> memberTeamDto = repository.search(condition);

        assertThat(memberTeamDto).extracting("username").containsExactly("member4");

        for (MemberTeamDto teamDto : memberTeamDto) {
            System.out.println("teamDto = " + teamDto);
        }


        //when

        //then
    }
}