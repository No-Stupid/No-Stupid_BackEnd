package com.example.project01.api;


import com.example.project01.dto.InterviewForm;
import com.example.project01.entity.Interview;
import com.example.project01.service.InterviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InterviewApiController {

    private final InterviewService interviewService;


    @PostMapping("/api/interview")
    public Interview saveInterview(@RequestBody @Valid InterviewForm interviewForm) {

        Interview interview = new Interview();

        interview.setCompanyName(interviewForm.getCompanyName());
        interview.setRole(interviewForm.getRole());
        interview.setQuestion(interviewForm.getQuestion());

        Long id = interviewService.save(interview);

        return new Interview(id);
    }

    @GetMapping("/api/interviewList")
    public List<Interview> interviewList() {
        return interviewService.list_interview();
    }

    @PutMapping("/api/interview/edit/{interviewId}")
    public Interview updateInterview(
            @PathVariable("interviewId") Long interviewId,
            @RequestBody @Valid InterviewForm interviewForm) {
        interviewService.updateInterview(interviewId, interviewForm.getCompanyName(), interviewForm.getRole(), interviewForm.getQuestion());
        Interview findInterview = interviewService.findOne(interviewId);
        return new Interview(findInterview.getId());
    }
}
