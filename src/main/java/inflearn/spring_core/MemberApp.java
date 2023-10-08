package inflearn.spring_core;

import inflearn.spring_core.config.AppConfig;
import inflearn.spring_core.member.Grade;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        MemberService memberService = new MemberServiceImpl();//직접 객체생성하던걸
//        AppConfig appConfig = new AppConfig(); // AppConfig를 통해 생성받고 받아오는 걸로 바꿈.
//        MemberService memberService = appConfig.memberService();

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member); // 회원가입이 됨.

        Member findMember = memberService.findMember(1L); // 조회
        // 찍어보기
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
