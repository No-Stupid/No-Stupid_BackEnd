package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "career")
public class Career {

    @Id
    @GeneratedValue
    @Column(name = "career_id")
    private Long id;

    private String company;

    private String role;

    private String job;

    private String joinCompanyDate;

    private String leaveCompanyDate;

}
