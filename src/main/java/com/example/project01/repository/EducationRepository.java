package com.example.project01.repository;

import com.example.project01.entity.Education;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EducationRepository {

    private final EntityManager em;

    public void save(Education education) {
        em.persist(education);
    }

    public List<Education> findAll() {
        return em.createQuery("select e from Education e", Education.class)
                .getResultList();
    }

    public Education findOne(Long id) {
        return em.find(Education.class, id);
    }


}
