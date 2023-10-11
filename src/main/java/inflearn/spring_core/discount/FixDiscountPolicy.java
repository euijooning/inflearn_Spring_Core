package inflearn.spring_core.discount;

import inflearn.spring_core.member.Grade;
import inflearn.spring_core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// 정액 할인 구현체
@Component
@Qualifier("fixDiscountPolicy")
public class FixDiscountPolicy implements DiscountPolicy {

    private int discoutnFixAmount = 1000; // 1,000원 할인


    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discoutnFixAmount; // VIP면 1,000원 할인
        } else {
            return 0;
        }
    }
}
