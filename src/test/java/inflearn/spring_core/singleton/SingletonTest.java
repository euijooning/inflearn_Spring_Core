package inflearn.spring_core.singleton;

import inflearn.spring_core.config.AppConfig;
import inflearn.spring_core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    /**
     * Ctrl + Shift + enter => (); 이거까지 한 번에 입력됨
     */
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    @Test
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회: 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회: 호출할 때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값 서로 다름을 확인하기 위한 작업
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        // 두 개가 서로 다름을 검증
        assertThat(memberService1).isNotSameAs(memberService2);
//cf.        assertThat(memberService1).isNotEqualTo(memberService2);
    }
}
