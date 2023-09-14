package com.example.project01.controller;

import com.example.project01.dto.CareerForm;
import com.example.project01.dto.EducationForm;
import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import com.example.project01.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/mypage")
public class MypageController {

    private final MypageService mypageService;

    @GetMapping("/education")
    public String educationForm(Model model) {
        model.addAttribute("educationForm", new EducationForm());
        return "mypage/educationForm";
    }

    @PostMapping("/education")
    public String education(EducationForm educationForm) {

        Education education = new Education();
        education.setSchool(educationForm.getSchool());
        education.setDegree(educationForm.getDegree());
        education.setMajor(educationForm.getMajor());
        //education.setAdmissionDate(educationForm.getAdmissionDate());
        //education.setGraduateDate(educationForm.getGraduateDate());
        education.setGrades(educationForm.getGrades());
        education.setPrize(educationForm.getPrize());

        mypageService.save_edu(education);

        return "redirect:/";
    }

    @GetMapping("/career")
    public String careerForm(Model model) {
        model.addAttribute("careerForm", new CareerForm());
        return "mypage/careerForm";
    }

    @PostMapping("/career")
    public String career(CareerForm careerForm) {

        Career career = new Career();
        career.setCompany(careerForm.getCompany());
        career.setRole(careerForm.getRole());
        career.setJob(careerForm.getJob());
        //career.setJoinCompanyDate(careerForm.getJoinCompanyDate());
        //career.setLeaveCompanyDate(careerForm.getLeaveCompanyDate());

        mypageService.save_career(career);

        return "redirect:/";
    }

}
