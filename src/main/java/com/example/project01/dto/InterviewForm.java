package com.example.project01.dto;

import com.example.project01.type.PassType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class InterviewForm {

    private Long id;

    private String companyName;

    private String role;

    private String question;

    private PassType passCheck;

    private String review;

}