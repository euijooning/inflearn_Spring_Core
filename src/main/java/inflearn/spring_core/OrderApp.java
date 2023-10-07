package inflearn.spring_core;

import inflearn.spring_core.member.Grade;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberService;
import inflearn.spring_core.member.MemberServiceImpl;
import inflearn.spring_core.order.Order;
import inflearn.spring_core.order.OrderService;
import inflearn.spring_core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
    }
}
