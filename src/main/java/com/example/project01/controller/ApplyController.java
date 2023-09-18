package com.example.project01.controller;

import com.example.project01.dto.ApplyInfo;
import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.service.ApplyInfoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ApplyController {

    private final ApplyInfoService applyInfoService;

    @GetMapping("/applyInfo")
    public String applyInfoForm(Model model) {
        model.addAttribute("applyInfoForm", new ApplyInfoForm());
        return "applyInfo/applyForm";
    }

    @PostMapping("/applyInfo")
    public String applyInfo(ApplyInfoForm applyInfoForm) {

        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setCompanyName(applyInfoForm.getCompanyName());
        applyInfo.setRole(applyInfoForm.getRole());
        applyInfo.setQualification(applyInfoForm.getQualification());
        //applyInfo.setDeadLine(applyInfoForm.getDeadLine());
        applyInfo.setHomePageUrl(applyInfoForm.getHomePageUrl());
        applyInfo.setSalary(applyInfoForm.getSalary());
        applyInfo.setApplyCheck(applyInfoForm.getApplyCheck());
        applyInfo.setCompanyTalent(applyInfoForm.getCompanyTalent());

        applyInfoService.save(applyInfo);

        return "redirect:/";
    }
}
