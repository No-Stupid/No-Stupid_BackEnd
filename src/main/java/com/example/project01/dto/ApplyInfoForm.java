package com.example.project01.dto;

import com.example.project01.type.ApplyType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApplyInfoForm {

    private String companyName;

    private String role;

    private String qualification;

    private String deadLine;

    private String homePageUrl;

    private String salary;

    private ApplyType applyCheck;

    private String companyTalent;
}
