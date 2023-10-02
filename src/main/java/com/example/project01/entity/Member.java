package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member")
@RequiredArgsConstructor
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String memberName;

    private String memberBirth;

    private String memberPhone;

    private String memberEmail;

    private String memberPwd;

    public Member(Long id) {
        this.id = id;
    }
}
