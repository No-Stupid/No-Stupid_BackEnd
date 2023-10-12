package com.example.project01.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "portfolio")
@RequiredArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue
    @Column(name = "portfolio_id")
    private Long id;

    private String platform;

    private String link;

    public Portfolio(Long id) {
        this.id = id;
    }
}
