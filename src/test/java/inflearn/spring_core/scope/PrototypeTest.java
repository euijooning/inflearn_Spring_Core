package inflearn.spring_core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    public void prototypeBeanFind() {
        // 프로토타입 빈을 사용하는 스프링 애플리케이션 컨텍스트를 생성합니다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("프로토타입 빈 1 찾기");

        // 스프링 컨테이너에서 PrototypeBean의 첫 번째 인스턴스를 가져옵니다.
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("프로토타입 빈 2 찾기");

        // 스프링 컨테이너에서 PrototypeBean의 두 번째 인스턴스를 가져옵니다.
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        System.out.println("prototypeBean1 = " + prototypeBean1);
        System.out.println("prototypeBean2 = " + prototypeBean2);

        // 두 참조가 서로 다른 객체를 가리키는지 확인하여 프로토타입 범위를 확인합니다.
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

        // 스프링 애플리케이션 컨텍스트를 닫습니다. 이로써 PreDestroy 메서드가 호출됩니다.
        ac.close(); // 종료
    }

    @Scope("prototype")
    static class PrototypeBean {

        // @PostConstruct로 주석이 달린 메서드는 빈 초기화 이후에 호출됩니다.
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init");
        }

        // @PreDestroy로 주석이 달린 메서드는 빈 파괴 이전에 호출됩니다.
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}