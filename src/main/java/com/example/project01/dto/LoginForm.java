package com.example.project01.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginForm {

    @NotEmpty
    private String memberEmail;

    @NotEmpty
    private String memberPwd;
}
