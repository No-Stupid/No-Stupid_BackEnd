package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "career")
@RequiredArgsConstructor
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

//    @ManyToOne
//    @JoinColumn(name = "member_id")
//    private Member member;

    public Career(Long id) {
        this.id = id;
    }
}
