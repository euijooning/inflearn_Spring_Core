package inflearn.spring_core.config;

import inflearn.spring_core.discount.DiscountPolicy;
import inflearn.spring_core.discount.FixDiscountPolicy;
import inflearn.spring_core.member.MemberRepository;
import inflearn.spring_core.member.MemberService;
import inflearn.spring_core.member.MemberServiceImpl;
import inflearn.spring_core.member.MemoryMemberRepository;
import inflearn.spring_core.order.OrderService;
import inflearn.spring_core.order.OrderServiceImpl;

// 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
public class AppConfig {

    //역할들을 드러나게 바꾼다!
    // ctrl alt M

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
//        return new RateDiscountPolicy();
    }
}
