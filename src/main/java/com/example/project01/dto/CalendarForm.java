package com.example.project01.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalendarForm {

    private Long id;

    private String date; // 날짜 입력

    private String text; // 일정 입력
}
