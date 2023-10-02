package com.example.project01.api;

import com.example.project01.dto.CareerForm;
import com.example.project01.dto.EducationForm;
import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import com.example.project01.service.MypageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MypageApiController {

    private final MypageService mypageService;

    @PostMapping("/api/mypage/edu")
    public Education saveEducation(@RequestBody @Valid EducationForm educationForm) {

        Education education = new Education();

        education.setSchool(educationForm.getSchool());
        education.setDegree(educationForm.getDegree());
        education.setMajor(educationForm.getMajor());
        education.setAdmissionDate(educationForm.getAdmissionDate());
        education.setGraduateDate(educationForm.getGraduateDate());
        education.setGrades(educationForm.getGrades());
        education.setPrize(educationForm.getPrize());

        Long id = mypageService.save_edu(education);

        return new Education(id);
    }

    @GetMapping("/api/mypage/edulist")
    public List<Education> educationList() {
        return mypageService.list_edu();
    }

    @PostMapping("/api/mypage/career")
    public Career saveCareer(@RequestBody @Valid CareerForm careerForm) {

        Career career = new Career();

        career.setCompany(careerForm.getCompany());
        career.setRole(careerForm.getRole());
        career.setJob(careerForm.getJob());
        career.setJoinCompanyDate(careerForm.getJoinCompanyDate());
        career.setLeaveCompanyDate(careerForm.getLeaveCompanyDate());

        Long id = mypageService.save_career(career);

        return new Career(id);
    }

    @GetMapping("/api/mypage/careerlist")
    public List<Career> careerList() {
        return mypageService.list_career();
    }

}
