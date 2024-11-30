package com.bhkim.querydsl;

import com.bhkim.querydsl.entity.Hello;
import com.bhkim.querydsl.entity.QHello;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@Transactional
class QueryDslApplicationTests {

    @Autowired
    EntityManager em;

    JPAQueryFactory query;

    @Test
    void contextLoads() {
        Hello hello = new Hello();
        em.persist(hello);

        JPAQueryFactory query = new JPAQueryFactory(em);
        QHello qHello = QHello.hello;

        Hello result = query.selectFrom(qHello).fetchOne();

        assertThat(result).isEqualTo(hello);
        //lombok 동작 확인 (hello.getId())
        assertThat(result.getId()).isEqualTo(hello.getId());

    }

}
