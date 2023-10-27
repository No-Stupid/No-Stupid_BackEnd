package com.example.project01.service;

import com.example.project01.entity.ApplyInfo;
import com.example.project01.entity.Calendar;
import com.example.project01.entity.Career;
import com.example.project01.repository.ApplyInfoRepository;
import com.example.project01.repository.CalendarRepository;
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
public class CalendarService {

    private final CalendarRepository calendarRepository;

    @Transactional
    public Long save(Calendar calendar) {
        calendarRepository.save(calendar);
        return calendar.getId();
    }

    public List<Calendar> list_calender() {
        log.info("service.list");
        return calendarRepository.findAll();
    }

    @Transactional
    public void updateCalendar(Long calendarId, String date, String text) {

        Calendar findCalendar = calendarRepository.findOne(calendarId);

        findCalendar.setDate(date);
        findCalendar.setText(text);
    }

    public Calendar findOne(Long calendarId) {
        return calendarRepository.findOne(calendarId);
    }
}
