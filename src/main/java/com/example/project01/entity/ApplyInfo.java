package com.example.project01.dto;

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

    //private String deadLine;

    private String homePageUrl;

    private String salary;

    private String applyCheck;

    private String companyTalent;
}
