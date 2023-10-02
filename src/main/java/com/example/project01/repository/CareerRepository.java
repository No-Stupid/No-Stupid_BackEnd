package com.example.project01.repository;

import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CareerRepository {

    private final EntityManager em;

    public void save(Career career) {
        em.persist(career);
    }

    public List<Career> findAll() {
        return em.createQuery("select c from Career c", Career.class)
                .getResultList();
    }

    public Career findOne(Long id) {
        return em.find(Career.class, id);
    }

}
