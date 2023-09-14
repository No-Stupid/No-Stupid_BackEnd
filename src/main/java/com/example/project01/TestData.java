package com.example.project01;

import com.example.project01.entity.Member;
import com.example.project01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TestData {

    private final MemberRepository memberRepository;

    public void init() {
        memberRepository.save(new Member());

        Member member = new Member();
        member.setMemberName("test");
        member.setMemberBirth("0422");
        member.setMemberPhone("010-1234-5678");
        member.setMemberEmail("test@test.com");
        member.setMemberPwd("test!");

        memberRepository.save(member);
    }
}
