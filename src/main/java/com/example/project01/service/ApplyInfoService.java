package com.example.project01.service;

import com.example.project01.dto.ApplyInfo;
import com.example.project01.repository.ApplyInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
