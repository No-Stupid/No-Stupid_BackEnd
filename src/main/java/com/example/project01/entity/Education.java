package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "education")
@RequiredArgsConstructor
public class Education {

    @Id
    @GeneratedValue
    @Column(name = "education_id")
    private Long id;

    private String school;

    private String degree;

    private String major;

    private String admissionDate;

    private String graduateDate;

    private float grades;

    private String prize;

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    public Education(Long id) {
        this.id = id;
    }
}
