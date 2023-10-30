package com.example.project01.api;


import com.example.project01.dto.member.MemberFormDTO;
import com.example.project01.dto.member.MemberUpdateForm;
import com.example.project01.entity.Member;
import com.example.project01.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/member")
    public Member saveMember(@RequestBody @Valid MemberFormDTO memberFormDTO) {
        Member member = new Member();

        member.setMemberName(memberFormDTO.getMemberName());
        member.setMemberBirth(memberFormDTO.getMemberBirth());
        member.setMemberPhone(memberFormDTO.getMemberPhone());
        member.setMemberEmail(memberFormDTO.getMemberEmail());
        member.setMemberPwd(memberFormDTO.getMemberPwd());

        Long id = memberService.join(member);

        return new Member(id);

    }
    @PutMapping("/api/member/edit/{id}")
    public Member updateMember(
            @PathVariable("id") Long id,
            @RequestBody @Valid MemberUpdateForm memberUpdateForm) {
        memberService.updateMember(id, memberUpdateForm.getMemberPhone(), memberUpdateForm.getMemberEmail(), memberUpdateForm.getMemberName(), memberUpdateForm.getMemberPwd());
        Member findMember = memberService.findOne(id);
        return new Member(findMember.getId());
    }

}
