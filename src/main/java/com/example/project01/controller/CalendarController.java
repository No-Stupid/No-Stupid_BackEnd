package com.example.project01.controller;

import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.dto.CalendarForm;
import com.example.project01.entity.ApplyInfo;
import com.example.project01.entity.Calendar;
import com.example.project01.service.ApplyInfoService;
import com.example.project01.service.CalendarService;
import com.example.project01.type.ApplyType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class CalendarController {

    private final CalendarService calendarService;

    @GetMapping("/calendar")
    public String calendarForm(Model model) {
        model.addAttribute("calendarForm", new CalendarForm());
        return "calendar/calendarForm";
    }

    @PostMapping("/calendar")
    public String calendar(CalendarForm calendarForm) {

        Calendar calendar = new Calendar();
        calendar.setDate(calendarForm.getDate());
        calendar.setText(calendarForm.getText());

        calendarService.save(calendar);

        return "redirect:/";
    }

    @GetMapping("/calendarList")
    public String calendarList(Model model) {
        log.info("controller");
        //log.info("list={}",List<ApplyInfo>);
        List<Calendar> calendars = calendarService.list_calender();
        log.info("list={}", calendars);
        log.info("service 호출");
        model.addAttribute("calendars", calendars);
        return "calendar/calendarList";
    }

    @GetMapping("/calendar/{calendarId}/edit")
    public String updateCalendarId(@PathVariable("calendarId") Long calendarId, Model model) {
        Calendar calendar = calendarService.findOne(calendarId);

        CalendarForm calendarForm = new CalendarForm();
        calendarForm.setId(calendar.getId());
        calendarForm.setDate(calendar.getDate());
        calendarForm.setText(calendar.getText());

        model.addAttribute("calendarForm", calendarForm);
        return "calendar/updateCalendar";
    }


    @PostMapping("/calendar/{calendarId}/edit")
    public String updateCalendar(@PathVariable Long calendarId, @ModelAttribute("calendarForm") CalendarForm calendarForm) {
        calendarService.updateCalendar(calendarId, calendarForm.getDate(), calendarForm.getText());

        return "redirect:/calendar/calendarList";
    }



}
