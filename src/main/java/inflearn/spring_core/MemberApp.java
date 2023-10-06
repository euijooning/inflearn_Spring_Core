package inflearn.spring_core;

import inflearn.spring_core.member.Grade;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberService;
import inflearn.spring_core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 회원가입이 됨.

        Member findMember = memberService.findMember(1L); // 조회

        // 찍어보기
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
