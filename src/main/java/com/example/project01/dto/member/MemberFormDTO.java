package com.example.project01.dto.member;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberFormDTO {

    @NotEmpty(message = "필수 입력 값입니다")
    private String memberName;

    @NotEmpty(message = "필수 입력 값입니다")
    private String memberBirth;

    @NotEmpty(message = "필수 입력 값입니다")
    private String memberPhone;

    @NotEmpty(message = "필수 입력 값입니다")
    @Email(message = "이메일 형식을 지켜 입력해주세요")
    private String memberEmail;

    @NotEmpty(message = "필수 입력 값입니다")
    private String memberPwd;
}
