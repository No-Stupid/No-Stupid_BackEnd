package com.example.project01.entity;

import com.example.project01.type.PassType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "interview")
@RequiredArgsConstructor
public class Interview {

    @Id
    @GeneratedValue
    @Column(name = "interview _id")
    private Long id;

    private String companyName;

    private String role;

    private String question;

    @Enumerated(EnumType.STRING)
    private PassType passCheck;

    private String review;

    public Interview(Long id) {
        this.id = id;
    }
}
