package com.example.project01.api;

import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.entity.ApplyInfo;
import com.example.project01.service.ApplyInfoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplyInfoApiController {

    private final ApplyInfoService applyInfoService;


    @PostMapping("/api/applyInfo")
    public ApplyInfo saveApplyInfo(@RequestBody @Valid ApplyInfoForm applyInfoForm) {
        ApplyInfo applyInfo = new ApplyInfo();

        applyInfo.setCompanyName(applyInfoForm.getCompanyName());
        applyInfo.setRole(applyInfoForm.getRole());
        applyInfo.setQualification(applyInfoForm.getQualification());
        applyInfo.setDeadLine(applyInfoForm.getDeadLine());
        applyInfo.setHomePageUrl(applyInfoForm.getHomePageUrl());
        applyInfo.setSalary(applyInfoForm.getSalary());
        applyInfo.setApplyCheck(applyInfoForm.getApplyCheck());
        applyInfo.setDocumentCheck(applyInfoForm.getDocumentCheck());
        applyInfo.setInterviewCheck(applyInfoForm.getInterviewCheck());
        applyInfo.setCompanyTalent(applyInfoForm.getCompanyTalent());

        Long id = applyInfoService.save(applyInfo);

        return new ApplyInfo(id);
    }

    @GetMapping("/api/applyList")
    public List<ApplyInfo> applyInfoList() {
        return applyInfoService.list_apply();
    }

    @PutMapping("/api/applyInfo/edit/{applyInfoId}")
    public ApplyInfo updateApplyInfo(
            @PathVariable("applyInfoId") Long applyInfoId,
            @RequestBody @Valid ApplyInfoForm applyInfoForm) {
        applyInfoService.updateApplyInfo(applyInfoId, applyInfoForm.getCompanyName(), applyInfoForm.getRole(), applyInfoForm.getQualification(), applyInfoForm.getDeadLine(), applyInfoForm.getHomePageUrl(), applyInfoForm.getSalary(), applyInfoForm.getApplyCheck(), applyInfoForm.getCompanyTalent());
        ApplyInfo findApplyInfo = applyInfoService.findOne(applyInfoId);
        return new ApplyInfo(findApplyInfo.getId());
    }

}
