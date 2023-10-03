package com.example.project01.controller;

import com.example.project01.dto.EducationForm;
import com.example.project01.entity.ApplyInfo;
import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.entity.Education;
import com.example.project01.service.ApplyInfoService;
import com.example.project01.type.ApplyType;
import com.example.project01.type.DeadLineDay;
import com.example.project01.type.DeadLineMonth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
        applyInfo.setDeadLine(applyInfoForm.getDeadLine());
        applyInfo.setHomePageUrl(applyInfoForm.getHomePageUrl());
        applyInfo.setSalary(applyInfoForm.getSalary());
        applyInfo.setApplyCheck(applyInfoForm.getApplyCheck());
        applyInfo.setCompanyTalent(applyInfoForm.getCompanyTalent());

        applyInfoService.save(applyInfo);

        return "redirect:/loginHome";
    }

    @GetMapping("/applyInfoList")
    public String applyList(Model model) {
        log.info("controller");
        //log.info("list={}",List<ApplyInfo>);
        List<ApplyInfo> applyInfos = applyInfoService.list_apply();
        log.info("list={}", applyInfos);
        log.info("service 호출");
        model.addAttribute("applyInfos", applyInfos);
        return "applyInfo/applyInfoList";
    }

    @ModelAttribute("applyTypes")
    public ApplyType[] applyTypes() {
        ApplyType[] values = ApplyType.values();
        return values;
    }

    @GetMapping("/apply/{appliInfoId}/edit")
    public String updateApplyInfoForm(@PathVariable("applyInfoId") Long applyInfoId, Model model) {
        ApplyInfo applyInfo = applyInfoService.findOne(applyInfoId);

        ApplyInfoForm applyInfoForm = new ApplyInfoForm();
        applyInfoForm.setId(applyInfo.getId());
        applyInfoForm.setCompanyName(applyInfo.getCompanyName());
        applyInfoForm.setRole(applyInfo.getRole());
        applyInfoForm.setQualification(applyInfo.getQualification());
        applyInfoForm.setDeadLine(applyInfo.getDeadLine());
        applyInfoForm.setHomePageUrl(applyInfo.getHomePageUrl());
        applyInfoForm.setSalary(applyInfo.getSalary());
        applyInfoForm.setApplyCheck(applyInfo.getApplyCheck());
        applyInfoForm.setCompanyTalent(applyInfo.getCompanyTalent());

        model.addAttribute("applyInfoForm", applyInfoForm);
        return "applyInfo/updateApplyInfo";
    }


    @PostMapping("/apply/{applyInfoId}/edit")
    public String updateApplyInfo(@PathVariable Long applyInfoId, @ModelAttribute("applyInfoForm") ApplyInfoForm applyInfoForm) {
        applyInfoService.updateApplyInfo(applyInfoId, applyInfoForm.getCompanyName(), applyInfoForm.getRole(), applyInfoForm.getQualification(), applyInfoForm.getDeadLine(), applyInfoForm.getHomePageUrl(), applyInfoForm.getSalary(), applyInfoForm.getApplyCheck(), applyInfoForm.getCompanyTalent());

        return "redirect:/applyInfo/applyInfoList";
    }




}
