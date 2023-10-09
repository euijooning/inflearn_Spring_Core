package inflearn.spring_core.config;

import inflearn.spring_core.discount.DiscountPolicy;
import inflearn.spring_core.discount.RateDiscountPolicy;
import inflearn.spring_core.member.MemberRepository;
import inflearn.spring_core.member.MemberService;
import inflearn.spring_core.member.MemberServiceImpl;
import inflearn.spring_core.member.MemoryMemberRepository;
import inflearn.spring_core.order.OrderService;
import inflearn.spring_core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 애플리케이션의 전체 동작 방식을 구성(config)하기 위해, 구현 객체를 생성하고, 연결하는 책임을 가지는 별도의 설정 클래스
@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        // 여기
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        // 여기
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }
    @Bean
    public MemberRepository memberRepository() {
        // 여기
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
