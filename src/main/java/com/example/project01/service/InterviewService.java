package com.example.project01.service;

import com.example.project01.entity.Interview;
import com.example.project01.repository.InterviewRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class InterviewService {

    private final InterviewRepository interviewRepository;

    @Transactional
    public Long save(Interview interview) {
        interviewRepository.save(interview);
        return interview.getId();
    }

    public List<Interview> list_interview() {
        log.info("service.list");
        return interviewRepository.findAll();
    }

    @Transactional
    public void updateInterview(Long interviewId, String companyName, String role, String question) {
        Interview findInterview = interviewRepository.findOne(interviewId);

        findInterview.setCompanyName(companyName);
        findInterview.setRole(role);
        findInterview.setQuestion(question);
    }

    public Interview findOne(Long interviewId) {
        return interviewRepository.findOne(interviewId);
    }


}
