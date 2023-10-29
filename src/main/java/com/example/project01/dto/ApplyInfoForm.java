package com.example.project01.dto;

import com.example.project01.type.ApplyType;
import com.example.project01.type.DocumentType;
import com.example.project01.type.InterviewType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyInfoForm {

    private Long id;

    private String companyName;

    private String role;

    private String qualification;

    private String deadLine;

    private String homePageUrl;

    private String salary;

    //@Enumerated(EnumType.STRING)
    private ApplyType applyCheck;

    private DocumentType documentCheck;

    private InterviewType interviewCheck;

    private String companyTalent;
}
