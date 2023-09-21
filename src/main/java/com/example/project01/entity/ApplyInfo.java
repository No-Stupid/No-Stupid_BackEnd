package com.example.project01.entity;

import com.example.project01.type.ApplyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "applyInfo")
public class ApplyInfo {

    @Id
    @GeneratedValue
    @Column(name = "applyInfo_id")
    private Long id;

    private String companyName;

    private String role;

    private String qualification;

    private String deadLine;

    private String homePageUrl;

    private String salary;

    @Enumerated(EnumType.STRING)
    private ApplyType applyCheck;

    private String companyTalent;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
