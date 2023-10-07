package inflearn.spring_core.discount;

import inflearn.spring_core.member.Grade;
import inflearn.spring_core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP는 10% 할인 적용")
    @Test
    void discount_yes() {
        //given
        Member member = new Member(1L, "vip", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(1000); // 10% 할인되는지를 확인
    }


    @DisplayName("VIP 아닌 자는 10% 할인 미적용")
    @Test
    void discount_no() {
        //given
        Member member = new Member(2L, "basic", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        assertThat(discount).isEqualTo(0);
    }
}