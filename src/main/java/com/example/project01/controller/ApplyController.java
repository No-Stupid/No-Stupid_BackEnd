package com.example.project01.controller;

import com.example.project01.entity.ApplyInfo;
import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.service.ApplyInfoService;
import com.example.project01.type.ApplyType;
import com.example.project01.type.DeadLineDay;
import com.example.project01.type.DeadLineMonth;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        //applyInfo.setDeadLine(applyInfoForm.getDeadLineMonth() + applyInfoForm.getDeadLineDay());
        applyInfo.setHomePageUrl(applyInfoForm.getHomePageUrl());
        applyInfo.setSalary(applyInfoForm.getSalary());
        applyInfo.setApplyCheck(applyInfoForm.getApplyCheck());
        applyInfo.setCompanyTalent(applyInfoForm.getCompanyTalent());

        applyInfoService.save(applyInfo);

        return "redirect:/";
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

    @ModelAttribute("deadLineMonths")
    public List<DeadLineMonth> deadLineMonths() {
        List<DeadLineMonth> deadLineMonths = new ArrayList<>();
        deadLineMonths.add(new DeadLineMonth(1, 1));
        deadLineMonths.add(new DeadLineMonth(2, 2));
        deadLineMonths.add(new DeadLineMonth(3, 3));
        return deadLineMonths;
    }

    @ModelAttribute("deadLineDays")
    public List<DeadLineDay> deadLineDays() {
        List<DeadLineDay> deadLineDays = new ArrayList<>();
        deadLineDays.add(new DeadLineDay(1, 1));
        deadLineDays.add(new DeadLineDay(2, 2));
        deadLineDays.add(new DeadLineDay(3, 3));
        return deadLineDays;
    }

}
