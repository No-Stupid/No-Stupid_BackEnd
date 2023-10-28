package com.example.project01.api;

import com.example.project01.dto.ApplyInfoForm;
import com.example.project01.dto.CalendarForm;
import com.example.project01.entity.ApplyInfo;
import com.example.project01.entity.Calendar;
import com.example.project01.service.CalendarService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CalendarApiController {

    private final CalendarService calendarService;

    @PostMapping("/api/calendar")
    public Calendar saveCalendar(@RequestBody @Valid CalendarForm calendarForm) {
        Calendar calendar = new Calendar();

        calendar.setDate(calendarForm.getDate());
        calendar.setText(calendarForm.getText());

        Long id = calendarService.save(calendar);

        return new Calendar(id);
    }

    @GetMapping("/api/calendarList")
    public List<Calendar> calendarList() {
        return calendarService.list_calender();
    }

    @PutMapping("/api/calendar/edit/{calendarId}")
    public Calendar updateCalendar(
            @PathVariable("calendarId") Long calendarId,
            @RequestBody @Valid CalendarForm calendarForm) {
        calendarService.updateCalendar(calendarId, calendarForm.getDate(), calendarForm.getText());

        Calendar findCalendar = calendarService.findOne(calendarId);
        return new Calendar(findCalendar.getId());
    }


}
