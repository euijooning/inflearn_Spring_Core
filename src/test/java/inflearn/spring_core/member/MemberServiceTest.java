package inflearn.spring_core.member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 테스트
class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @DisplayName("회원가입 테스트")
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP); // 멤버 세팅

        //when
        memberService.join(member); // 가입시킴
        Member findMember = memberService.findMember(1L); // 멤버 찾기

        //then
        assertThat(member).isEqualTo(findMember); // 가입한 멤버와 조회한 멤버가 같은지 검증
    }
}