package com.example.project01.repository;

import com.example.project01.entity.Interview;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InterviewRepository {
    private final EntityManager em;

    public void save(Interview interview) {
        em.persist(interview);
    }

    public List<Interview> findAll() {
        return em.createQuery("select i from Interview i", Interview.class)
                .getResultList();
    }

    public Interview findOne(Long id) {
        return em.find(Interview.class, id);
    }

}
