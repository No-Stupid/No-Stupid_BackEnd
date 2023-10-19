package com.example.project01.controller;

import com.example.project01.argumentResolver.Login;
import com.example.project01.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HomeController {

//    @GetMapping("/")
//    public String home() {
//        log.info("home controller");
//        return "home";
//    }
    @GetMapping("/")
    public String home(@Login Member loginMember, Model model) {

        if(loginMember == null) {
            return "home";
        }

        model.addAttribute("member", loginMember);
        return "loginHome";
    }

//    @GetMapping("/home")
//    public String loginHome() {
//        return "loginHome";
//    }

}
