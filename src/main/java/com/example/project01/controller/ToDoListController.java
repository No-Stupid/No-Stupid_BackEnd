package com.example.project01.controller;

import com.example.project01.dto.ToDoListForm;
import com.example.project01.entity.ToDoList;
import com.example.project01.service.ToDoListService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ToDoListController {

    private final ToDoListService toDoListService;

    @GetMapping("/toDoList")
    public String toDoListForm(Model model) {
        model.addAttribute("toDoListForm", new ToDoListForm());
        return "toDoList/toDoListForm";
    }

    @PostMapping("/toDoList")
    public String toDoList(ToDoListForm toDoListForm) {

        ToDoList toDoList = new ToDoList();
        toDoList.setMemo(toDoListForm.getMemo());

        toDoListService.save(toDoList);

        return "redirect:/";
    }

    @GetMapping("/toDo_list")
    public String toDoList(Model model) {
        log.info("controller");
        //log.info("list={}",List<ApplyInfo>);
        List<ToDoList> toDoLists = toDoListService.list_todo();
        log.info("list={}", toDoLists);
        log.info("service 호출");
        model.addAttribute("todoLists", toDoLists);
        return "toDoList/toDoList";
    }

    @GetMapping("/toDoList/{toDoListId}/edit")
    public String updateToDoListForm(@PathVariable("toDoListId") Long toDoListId, Model model) {
        ToDoList toDoList = toDoListService.findOne(toDoListId);

        ToDoListForm toDoListForm = new ToDoListForm();
        toDoListForm.setId(toDoList.getId());
        toDoListForm.setMemo(toDoList.getMemo());

        model.addAttribute("toDoListForm",toDoListForm);
        return "toDoList/updateToDoList";
    }


    @PostMapping("/todo/{toDoListId}/edit")
    public String updateToDoList(@PathVariable Long toDoListId, @ModelAttribute("toDoListForm") ToDoListForm toDoListForm) {
        toDoListService.updateToDoList(toDoListId, toDoListForm.getMemo());

        return "redirect:/toDoList/toDoList";
    }


}
