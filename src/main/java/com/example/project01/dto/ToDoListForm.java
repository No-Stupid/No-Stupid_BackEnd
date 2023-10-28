package com.example.project01.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ToDoListForm {

    private Long id;
    private String memo;

}