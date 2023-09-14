package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "member")
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

}
