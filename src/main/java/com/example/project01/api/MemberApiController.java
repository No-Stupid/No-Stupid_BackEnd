package com.example.project01.api;


import com.example.project01.api.data.CreateMemberRequest;
import com.example.project01.api.data.CreateMemberResponse;
import com.example.project01.dto.MemberFormDTO;
import com.example.project01.entity.Member;
import com.example.project01.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
