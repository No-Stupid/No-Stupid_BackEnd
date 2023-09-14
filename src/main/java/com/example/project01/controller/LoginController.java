package com.example.project01.controller;

import com.example.project01.dto.LoginForm;
import com.example.project01.entity.Member;
import com.example.project01.service.MemberService;
import com.example.project01.session.SessionConst;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final MemberService memberService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "members/loginForm";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute LoginForm loginForm, BindingResult bindingResult,
                        @RequestParam(defaultValue = "/") String redirectURL,
                        HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "members/loginForm";
        }

        log.info("hasError 통과");

        Member loginMember = memberService.login(loginForm.getMemberEmail(), loginForm.getMemberPwd());

        if (loginMember == null) {
            bindingResult.reject("loginFail", "아이디 또는 비밀번호가 맞지 않습니다");
            log.info("아이디 또는 비밀번호가 맞지 않음");
            return "members/loginForm";
        }

        log.info("세션 전");

        HttpSession session = request.getSession();

        session.setAttribute(SessionConst.LOGIN_MEMBER, loginMember);

        log.info("return 직전");

        return "loginHome";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if(session != null) {
            session.invalidate();
        }

        return "redirect:/";
    }

    private void expireCookie(HttpServletResponse response, String cookieName) {
        Cookie cookie = new Cookie(cookieName, null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }


}
