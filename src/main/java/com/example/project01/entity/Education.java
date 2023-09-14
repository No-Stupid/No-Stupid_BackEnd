package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "education")
public class Education {

    @Id
    @GeneratedValue
    @Column(name = "education_id")
    private Long id;

    private String school;

    private String degree;

    private String major;

    //private int admissionDate;

    //private int graduateDate;

    private float grades;

    private String prize;

}
