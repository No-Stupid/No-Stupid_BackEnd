package com.example.project01.dto.mypage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CareerForm {

    private Long id;

    private String company;

    private String role;

    private String job;

    private String joinCompanyDate;

    private String leaveCompanyDate;
}
