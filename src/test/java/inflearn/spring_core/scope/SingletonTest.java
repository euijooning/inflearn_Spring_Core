package inflearn.spring_core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    public void singletonBeanFind() {
        // SingletonBean 클래스 구성을 기반으로 스프링 애플리케이션 컨텍스트를 생성합니다.
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        // 스프링 컨테이너에서 SingletonBean의 두 인스턴스를 가져옵니다.
        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);

        // singletonBean1과 singletonBean2의 참조를 출력합니다.
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);

        // 두 참조가 동일한 객체를 가리키는지 확인하여 싱글톤 범위를 확인합니다.
        assertThat(singletonBean1).isSameAs(singletonBean2);

        // 스프링 애플리케이션 컨텍스트를 닫습니다. 이로써 PreDestroy 메서드가 호출됩니다.
        ac.close(); // 종료 (컨텍스트 종료)
    }

    @Scope("singleton")
    static class SingletonBean {

        // @PostConstruct로 주석이 달린 메서드는 빈 초기화 이후에 호출됩니다.
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }

        // @PreDestroy로 주석이 달린 메서드는 빈 파괴 이전에 호출됩니다.
        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }

}