package com.example.project01.repository;

import com.example.project01.entity.Education;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EducationRepository {

    private final EntityManager em;

    public void save(Education education) {
        em.persist(education);
    }
}
