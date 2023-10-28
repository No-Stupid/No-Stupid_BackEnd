package com.example.project01.api;

import com.example.project01.dto.ToDoListForm;
import com.example.project01.entity.ToDoList;
import com.example.project01.service.ToDoListService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ToDoListApiController {

    private final ToDoListService toDoListService;


    @PostMapping("/api/toDoList")
    public ToDoList saveToDoList(@RequestBody @Valid ToDoListForm toDoListForm) {

        ToDoList toDoList = new ToDoList();

        toDoList.setMemo(toDoListForm.getMemo());

        Long id = toDoListService.save(toDoList);
        return new ToDoList(id);
    }

    @GetMapping("/api/toDo_list")
    public List<ToDoList> toDo_list() {
        return toDoListService.list_todo();
    }

    @PostMapping("/api/toDoList/edit/{toDoListId}")
    public ToDoList updateToDoList(
            @PathVariable("toDoList_id") Long toDoListId,
            @RequestBody @Valid ToDoListForm toDoListForm) {
        toDoListService.updateToDoList(toDoListId, toDoListForm.getMemo());
        ToDoList findToDoList = toDoListService.findOne(toDoListId);
        return new ToDoList(findToDoList.getId());
    }
}
