package com.example.project01.repository;

import com.example.project01.dto.ApplyInfo;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ApplyInfoRepository {

    private final EntityManager em;

    public void save(ApplyInfo applyInfo) {
        em.persist(applyInfo);
    }
}
