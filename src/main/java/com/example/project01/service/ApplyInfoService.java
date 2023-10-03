package com.example.project01.service;

import com.example.project01.entity.ApplyInfo;
import com.example.project01.entity.Career;
import com.example.project01.repository.ApplyInfoRepository;
import com.example.project01.type.ApplyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class ApplyInfoService {

    private final ApplyInfoRepository applyInfoRepository;

    @Transactional
    public Long save(ApplyInfo applyInfo) {
        applyInfoRepository.save(applyInfo);
        return applyInfo.getId();
    }

    public List<ApplyInfo> list_apply() {
        log.info("service.list");
        return applyInfoRepository.findAll();
    }

    @Transactional
    public void updateApplyInfo(Long applyInfoId, String companyName, String role, String qualification, String deadLine, String homePageUrl, String salary, ApplyType applyCheck, String companyTalent) {
        ApplyInfo findApplyInfo = applyInfoRepository.findOne(applyInfoId);

        findApplyInfo.setCompanyName(companyName);
        findApplyInfo.setRole(role);
        findApplyInfo.setQualification(qualification);
        findApplyInfo.setDeadLine(deadLine);
        findApplyInfo.setHomePageUrl(homePageUrl);
        findApplyInfo.setSalary(salary);
        findApplyInfo.setApplyCheck(applyCheck);
        findApplyInfo.setCompanyTalent(companyTalent);
    }

    public ApplyInfo findOne(Long applyInfoId) {
        return applyInfoRepository.findOne(applyInfoId);
    }

}
