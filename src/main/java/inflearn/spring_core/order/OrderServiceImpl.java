package inflearn.spring_core.order;

import inflearn.spring_core.discount.DiscountPolicy;
import inflearn.spring_core.member.Member;
import inflearn.spring_core.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); step1. 이거 삭제
//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy(); step2. 이거 삭제
    private final DiscountPolicy discountPolicy; // step3. 인터페이스에만 의존하도록 설계와 코드를 변경
    // 실제 실행을 해보면 NPE(null pointer exception)가 발생한다.


    //테스트 용도 추가
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


    // 생성자 추가
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
        /*
        discountPolicy 얘는 어떤 discountPolicy 구현체를 넣어줄 지 전혀 모른다.(클래스 정보x)
         */
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
