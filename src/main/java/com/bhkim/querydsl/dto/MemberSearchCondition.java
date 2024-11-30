package com.bhkim.querydsl.dto;

import lombok.Data;

@Data
public class MemberCondition {
    private String username;
    private String teamName;
    private Integer ageGoe;
    private Integer ageLoe;
}
