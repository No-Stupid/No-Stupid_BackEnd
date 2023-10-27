package com.example.project01.repository;

import com.example.project01.entity.ApplyInfo;
import com.example.project01.entity.Calendar;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class CalendarRepository {
    private final EntityManager em;

    public void save(Calendar calendar) {
        em.persist(calendar);
    }

    public List<Calendar> findAll() {
        log.info("CalendarRepository.findAll");
        return em.createQuery("select c from Calendar c", Calendar.class)
                .getResultList();
    }

    public Calendar findOne(Long id) {
        return em.find(Calendar.class, id);
    }


}
