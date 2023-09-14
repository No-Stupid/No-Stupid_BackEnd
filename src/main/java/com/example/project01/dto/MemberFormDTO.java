package com.example.project01.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDTO {

    @NotEmpty
    private String memberName;

    @NotEmpty
    private String memberBirth;

    @NotEmpty
    private String memberPhone;

    @NotEmpty
    @Email
    private String memberEmail;

    @NotEmpty
    private String memberPwd;
}
