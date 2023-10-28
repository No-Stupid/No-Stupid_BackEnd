package com.example.project01.repository;

import com.example.project01.entity.ToDoList;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor

public class ToDoListRepository {
    private final EntityManager em;

    public void save(ToDoList toDoList)
    {
        em.persist(toDoList);
    }

    public List<ToDoList> findAll() {
        return em.createQuery("select t from ToDoList t", ToDoList.class)
                .getResultList();
    }

    public ToDoList findOne(Long id) {
        return em.find(ToDoList.class, id);
    }

}
