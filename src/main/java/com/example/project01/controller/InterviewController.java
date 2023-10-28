package com.example.project01.controller;

import com.example.project01.dto.InterviewForm;
import com.example.project01.entity.Interview;
import com.example.project01.service.InterviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class InterviewController {

    private final InterviewService interviewService;

    @GetMapping("/interview")
    public String interviewForm(Model model) {
        model.addAttribute("interviewForm", new InterviewForm());
        return "interview/interviewForm";
    }

    @PostMapping("/interview")
    public String interview(InterviewForm interviewForm) {

        Interview interview = new Interview();
        interview.setCompanyName(interviewForm.getCompanyName());
        interview.setRole(interviewForm.getRole());
        interview.setQuestion(interviewForm.getQuestion());

        interviewService.save(interview);

        return "redirect:/";
    }

    @GetMapping("/interviewList")
    public String interviewList(Model model) {
        log.info("controller");
        //log.info("list={}",List<ApplyInfo>);
        List<Interview> interviews = interviewService.list_interview();
        log.info("list={}", interviews);
        log.info("service 호출");
        model.addAttribute("interviews", interviews);
        return "interview/interviewList";
    }


    @GetMapping("/interview/{interviewId}/edit")
    public String updateInterviewForm(@PathVariable("interviewId") Long interviewId, Model model) {
        Interview interview = interviewService.findOne(interviewId);

        InterviewForm interviewForm = new InterviewForm();
        interviewForm.setId(interview.getId());
        interview.setCompanyName(interview.getCompanyName());
        interview.setRole(interview.getRole());
        interview.setQuestion(interview.getQuestion());

        model.addAttribute("interviewList",interviewForm);
        return "interview/updateInterview";
    }


    @PostMapping("/interview/{interviewId}/edit")
    public String updateInterview(@PathVariable Long interviewId, @ModelAttribute("interviewForm") InterviewForm interviewForm) {
        interviewService.updateInterview(interviewId, interviewForm.getCompanyName(), interviewForm.getRole(), interviewForm.getQuestion());

        return "redirect:/interview/interviewList";
    }



}
