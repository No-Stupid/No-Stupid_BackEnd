package com.example.project01.entity;

import com.example.project01.type.ApplyType;
import com.example.project01.type.DocumentType;
import com.example.project01.type.InterviewType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "applyInfo")
@RequiredArgsConstructor
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

    @Enumerated(EnumType.STRING)
    private DocumentType documentCheck;

    @Enumerated(EnumType.STRING)
    private InterviewType interviewCheck;

    private String companyTalent;

    public ApplyInfo(Long id) {
        this.id = id;
    }
}
