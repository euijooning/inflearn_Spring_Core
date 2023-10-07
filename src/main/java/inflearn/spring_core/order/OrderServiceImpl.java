package inflearn.spring_core.order;

import inflearn.spring_core.discount.DiscountPolicy;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberRepository;
import inflearn.spring_core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); step1. 이거 삭제
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); step2. 이거 삭제
    private DiscountPolicy discountPolicy; // step3. 인터페이스에만 의존하도록 설계와 코드를 변경
    // 실제 실행을 해보면 NPE(null pointer exception)가 발생한다.



    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
