package com.example.project01.repository;

import com.example.project01.entity.Education;
import com.example.project01.entity.Portfolio;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PortfolioRepository {

    private final EntityManager em;

    public void save(Portfolio portfolio) {
        em.persist(portfolio);
    }

    public List<Portfolio> findAll() {
        return em.createQuery("select p from Portfolio p", Portfolio.class)
                .getResultList();
    }

    public Portfolio findOne(Long id) {
        return em.find(Portfolio.class, id);
    }

}
