package com.example.project01.service;

import com.example.project01.entity.ApplyInfo;
import com.example.project01.repository.ApplyInfoRepository;
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

}
