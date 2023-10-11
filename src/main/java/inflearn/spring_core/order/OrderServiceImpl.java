package inflearn.spring_core.order;

import inflearn.spring_core.discount.DiscountPolicy;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @Qualifier("mainDiscountPolicy") DiscountPolicy discountPolicy) { // 여기 변경
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy; // 여기 변경
    }

    //테스트 용도 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
