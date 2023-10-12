package com.example.project01.api;

import com.example.project01.dto.mypage.CareerForm;
import com.example.project01.dto.mypage.EducationForm;
import com.example.project01.dto.mypage.PortfolioForm;
import com.example.project01.entity.Career;
import com.example.project01.entity.Education;
import com.example.project01.entity.Portfolio;
import com.example.project01.service.MypageService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/api/education/edit/{educationId}")
    public Education updateEducation(
            @PathVariable("educationId") Long educationId,
            @RequestBody @Valid EducationForm educationForm) {
        mypageService.updateEducation(educationId, educationForm.getSchool(), educationForm.getDegree(), educationForm.getMajor(), educationForm.getAdmissionDate(), educationForm.getGraduateDate(), educationForm.getGrades(), educationForm.getPrize());
        Education findEducation = mypageService.findOneEdu(educationId);
        return new Education(findEducation.getId());
    }



    //-------경력-------

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

    @PutMapping("/api/career/edit/{careerId}")
    public Career updateCareer(
            @PathVariable("careerId") Long careerId,
            @RequestBody @Valid CareerForm careerForm) {
        mypageService.updateCareer(careerId, careerForm.getCompany(), careerForm.getRole(), careerForm.getJob(), careerForm.getJoinCompanyDate(), careerForm.getLeaveCompanyDate());
        Career findCareer = mypageService.findOneCareer(careerId);
        return new Career(findCareer.getId());
    }

    //------포트폴리오------
    @PostMapping("/api/mypage/portfolio")
    public Portfolio savePortfolio(@RequestBody @Valid PortfolioForm portfolioForm) {

        Portfolio portfolio = new Portfolio();

        portfolio.setPlatform(portfolioForm.getPlatform());
        portfolio.setLink(portfolio.getLink());

        Long id = mypageService.save_portfolio(portfolio);

        return new Portfolio(id);
    }

    @GetMapping("/api/mypage/portfoliolist")
    public List<Portfolio> portfolioList() {
        return mypageService.list_portfolio();
    }

    @PutMapping("/api/portfolio/edit/{portfolioId}")
    public Portfolio updatePortfolio(
            @PathVariable("portfolioId") Long portfolioId,
            @RequestBody @Valid PortfolioForm portfolioForm) {
        mypageService.updatePortfolio(portfolioId, portfolioForm.getPlatform(), portfolioForm.getLink());
        Portfolio findPortfolio = mypageService.findOnePortfolio(portfolioId);
        return new Portfolio(findPortfolio.getId());
    }


}
