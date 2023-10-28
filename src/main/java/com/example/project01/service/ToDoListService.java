package com.example.project01.service;

import com.example.project01.entity.ToDoList;
import com.example.project01.repository.ToDoListRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ToDoListService {

    private final ToDoListRepository toDoListRepository;

    @Transactional
    public Long save(ToDoList toDoList) {
        toDoListRepository.save(toDoList);
        return toDoList.getId();
    }

    public List<ToDoList> list_todo() {
        log.info("service.list");
        return toDoListRepository.findAll();
    }

    @Transactional
    public void updateToDoList(Long toDoListId, String memo) {

        ToDoList findToDoList = toDoListRepository.findOne(toDoListId);
        findToDoList.setMemo(memo);
    }

    public ToDoList findOne(Long toDoListId) {
        return toDoListRepository.findOne(toDoListId);
    }


}
