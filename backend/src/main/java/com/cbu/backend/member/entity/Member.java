package com.cbu.backend.member.entity;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountId;

    private String password;

    @Column(nullable = false)
    private String name;

    private String major;

}

class OAuth2Member {

}
//fields
// id
// password
// name
// id, accountId, password, 이름, 학번, 학과, 기수, 전화번호, 권한, 소셜, 가입일자, 수정일자,
// 탈퇴일자, 프로필사진, 성별, 나이 등등
// 소셜 로그인

// Plan A : 소셜 로그인 Class를 따로 뺄꺼냐
// Plan B : Member 클래스에서 Null을 허욜 할 것 인가