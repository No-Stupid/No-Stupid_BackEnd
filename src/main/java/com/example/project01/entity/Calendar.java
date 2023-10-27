package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "calendar")
@RequiredArgsConstructor
public class Calendar {
    @Id
    @GeneratedValue
    @Column(name = "calendar_id")
    private Long id;

    private String date;  //날짜 입력

    private String text;  //일정 입력

    public Calendar(Long id) {
        this.id = id;
    }


}
