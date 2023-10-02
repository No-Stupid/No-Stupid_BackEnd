package com.example.project01.service;

import com.example.project01.entity.Member;
import com.example.project01.exception.EmailCheckException;
import com.example.project01.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByEmail(member.getMemberEmail());
        if(!findMembers.isEmpty()) {
            log.info("가입된 이메일");
            throw new EmailCheckException("이미 가입된 이메일");
        }
    }

    public Member login(String memberEmail, String memberPwd) {
        List<Member> findMember = memberRepository.findByEmail(memberEmail);
        Member member = findMember.get(0);

        if (member.getMemberPwd().equals(memberPwd)) {
            return member;
        } else {
            return null;
        }
    }

    @Transactional
    public void updateMember(Long id, String memberPhone, String memberEmail, String memberPwd){
        Member findMember = memberRepository.findOne(id);
        findMember.setMemberPhone(memberPhone);
        findMember.setMemberEmail(memberEmail);
        findMember.setMemberPwd(memberPwd);

    }
}
