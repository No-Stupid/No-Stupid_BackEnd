package com.example.project01.controller;

import com.example.project01.dto.mypage.CareerForm;
import com.example.project01.dto.mypage.EducationForm;
import com.example.project01.dto.mypage.PortfolioForm;
import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import com.example.project01.entity.Portfolio;
import com.example.project01.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        education.setAdmissionDate(educationForm.getAdmissionDate());
        education.setGraduateDate(educationForm.getGraduateDate());
        education.setGrades(educationForm.getGrades());
        education.setPrize(educationForm.getPrize());

        mypageService.save_edu(education);

        return "loginHome";
    }

    @GetMapping("/educationList")
    public String eduList(Model model) {
        List<Education> educations = mypageService.list_edu();
        model.addAttribute("educations", educations);
        return "mypage/educationList";
    }

    @GetMapping("/education/{educationId}/edit")
    public String updateEducationForm(@PathVariable("educationId") Long educationId, Model model) {
        Education education = mypageService.findOneEdu(educationId);

        EducationForm educationForm = new EducationForm();
        educationForm.setId(education.getId());
        educationForm.setSchool(education.getSchool());
        educationForm.setDegree(education.getDegree());
        educationForm.setMajor(education.getMajor());
        educationForm.setAdmissionDate(education.getAdmissionDate());
        educationForm.setGraduateDate(education.getGraduateDate());
        educationForm.setGrades(education.getGrades());
        educationForm.setPrize(education.getPrize());

        model.addAttribute("educationForm", educationForm);
        return "mypage/updateEducation";
    }

    @PostMapping("/education/{educationId}/edit")
    public String updateEducation(@PathVariable Long educationId, @ModelAttribute("educationForm") EducationForm educationForm) {
        mypageService.updateEducation(educationId, educationForm.getSchool(), educationForm.getDegree(), educationForm.getMajor(), educationForm.getAdmissionDate(), educationForm.getGraduateDate(), educationForm.getGrades(), educationForm.getPrize());

        return "redirect:/mypage/educationList";
    }



    //--------경력------
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
        career.setJoinCompanyDate(careerForm.getJoinCompanyDate());
        career.setLeaveCompanyDate(careerForm.getLeaveCompanyDate());

        mypageService.save_career(career);

        return "loginHome";
    }

    @GetMapping("/careerList")
    public String careerList(Model model) {
        List<Career> careers = mypageService.list_career();
        model.addAttribute("careers", careers);
        return "mypage/careerList";
    }

    @GetMapping("/career/{careerId}/edit")
    public String updateCareerForm(@PathVariable("careerId") Long careerId, Model model) {
        Career career = mypageService.findOneCareer(careerId);

        CareerForm careerForm = new CareerForm();
        careerForm.setId(career.getId());
        careerForm.setCompany(career.getCompany());
        careerForm.setRole(career.getRole());
        careerForm.setJob(career.getJob());
        careerForm.setJoinCompanyDate(career.getJoinCompanyDate());
        careerForm.setLeaveCompanyDate(career.getLeaveCompanyDate());

        model.addAttribute("careerForm", careerForm);
        return "mypage/updateCareer";
    }

    @PostMapping("/career/{careerId}/edit")
    public String updateCareer(@PathVariable Long careerId, @ModelAttribute("careerForm") CareerForm careerForm) {
        mypageService.updateCareer(careerId, careerForm.getCompany(), careerForm.getRole(), careerForm.getJob(), careerForm.getJoinCompanyDate(), careerForm.getLeaveCompanyDate());

        return "redirect:/mypage/careerList";
    }


    //------포트폴리오------

    @GetMapping("/portfolio")
    public String portfolioForm(Model model) {
        model.addAttribute("portfolioForm", new PortfolioForm());
        return "mypage/portfolioForm";
    }

    @PostMapping("/portfolio")
    public String portfolio(PortfolioForm portfolioForm) {

        Portfolio portfolio = new Portfolio();
        portfolio.setPlatform(portfolioForm.getPlatform());
        portfolio.setLink(portfolioForm.getLink());

        mypageService.save_portfolio(portfolio);

        return "loginHome";
    }

    @GetMapping("/portfolioList")
    public String portfolioList(Model model) {
        List<Portfolio> portfolios = mypageService.list_portfolio();
        model.addAttribute("portfolio", portfolios);
        return "mypage/portfolioList";
    }

    @GetMapping("/portfolio/{portfolioId}/edit")
    public String updatePortfolioForm(@PathVariable("portfolioId") Long portfolioId, Model model) {
        Portfolio portfolio = mypageService.findOnePortfolio(portfolioId);

        PortfolioForm portfolioForm = new PortfolioForm();
        portfolioForm.setPlatform(portfolio.getPlatform());
        portfolioForm.setLink(portfolio.getLink());

        model.addAttribute("portfolioForm", portfolioForm);

        return "mypage/updatePortfolio";
    }

    @PostMapping("/portfolio/{portfolioId}/edit")
    public String updatePortfolio(@PathVariable Long portfolioId, @ModelAttribute("portfolioForm") PortfolioForm portfolioForm) {
        mypageService.updatePortfolio(portfolioId, portfolioForm.getPlatform(), portfolioForm.getLink());

        return "redirect:/mypage/portfolioList";
    }

}
