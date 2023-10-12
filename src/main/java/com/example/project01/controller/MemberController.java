package com.example.project01.controller;

import com.example.project01.dto.member.MemberFormDTO;
import com.example.project01.dto.member.MemberUpdateForm;
import com.example.project01.entity.Member;
import com.example.project01.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(Model model) {
        model.addAttribute("memberFormDTO", new MemberFormDTO());
        return "members/joinForm";
    }

    @PostMapping("/join")
    public String join(@Valid MemberFormDTO memberFormDTO, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {

            return "members/joinForm";
        }

        log.info("controller 호출");

        Member member = new Member();
        //BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setMemberName(memberFormDTO.getMemberName());
        member.setMemberBirth(memberFormDTO.getMemberBirth());
        member.setMemberPhone(memberFormDTO.getMemberPhone());
        member.setMemberEmail(memberFormDTO.getMemberEmail());
        member.setMemberPwd(memberFormDTO.getMemberPwd());
        // member.setMemberPwd(passwordEncoder.encode(memberFormDTO.getMemberPwd()));

        log.info("member={}",member);

        memberService.join(member);

        log.info("member={}",member);

        return "redirect:/";
    }

    @GetMapping("/member/edit/{id}")
    public String updateForm(Model model) {
        model.addAttribute("MemberUpdateForm", new MemberUpdateForm());

        return "/members/updateForm";
    }

    @PostMapping("/member/edit/{id}")
    public String updateMember(@PathVariable Long id, @ModelAttribute("memberUpdateForm")MemberUpdateForm memberUpdateForm) {
        memberService.updateMember(id, memberUpdateForm.getMemberPhone(), memberUpdateForm.getMemberEmail(), memberUpdateForm.getMemberPwd());

        return "redirect:/loginHome";
    }


}
