package com.example.project01.service;

import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import com.example.project01.repository.CareerRepository;
import com.example.project01.repository.EducationRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MypageService {

    private final EducationRepository educationRepository;
    private final CareerRepository careerRepository;

    @Transactional
    public Long save_edu(Education education) {
        educationRepository.save(education);
        return education.getId();
    }

    public List<Education> list_edu() {
        return educationRepository.findAll();
    }

    @Transactional
    public void updateEducation(Long educationId, String school, String degree, String major, String admissionDate, String graduateDate, float grades, String prize) {
        Education findEducation = educationRepository.findOne(educationId);
        findEducation.setSchool(school);
        findEducation.setDegree(degree);
        findEducation.setMajor(major);
        findEducation.setAdmissionDate(admissionDate);
        findEducation.setGraduateDate(graduateDate);
        findEducation.setGrades(grades);
        findEducation.setPrize(prize);
    }

    public Education findOneEdu(Long educationId) {
        return educationRepository.findOne(educationId);
    }



    //---------경력---------
    @Transactional
    public Long save_career(Career career) {
        careerRepository.save(career);
        return career.getId();
    }

    public List<Career> list_career() {
        return careerRepository.findAll();
    }

    @Transactional
    public void updateCareer(Long careerId, String company, String role, String job, String joinCompanyDate, String leaveCompanyDate) {
        Career findCareer = careerRepository.findOne(careerId);
        findCareer.setCompany(company);
        findCareer.setRole(role);
        findCareer.setJob(job);
        findCareer.setJoinCompanyDate(joinCompanyDate);
        findCareer.setLeaveCompanyDate(leaveCompanyDate);
    }

    public Career findOne(Long careerId) {
        return careerRepository.findOne(careerId);
    }

}
