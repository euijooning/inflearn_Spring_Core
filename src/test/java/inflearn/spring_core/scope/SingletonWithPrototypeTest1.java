package inflearn.spring_core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonWithPrototypeTest1 {
    @Test
    void prototypeFind() {
        // 빈을 관리하기 위한 Spring 애플리케이션 컨텍스트를 생성합니다.
        AnnotationConfigApplicationContext ac
                = new AnnotationConfigApplicationContext(ClientBean.class, PrototypeBean.class);

        // 컨텍스트에서 PrototypeBean의 첫 번째 인스턴스를 가져옵니다.
        PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        prototypeBean1.addCount();
        // 첫 번째 인스턴스의 카운트가 1인지 확인합니다.
        assertThat(prototypeBean1.getCount()).isEqualTo(1);

        // 컨텍스트에서 PrototypeBean의 두 번째 인스턴스를 가져옵니다.
        PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        prototypeBean2.addCount();
        // 두 번째 인스턴스의 카운트가 1인지 확인합니다.
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }
    @Scope("singleton")
    static class ClientBean { // 추가
        private final PrototypeBean prototypeBean;
        @Autowired
        public ClientBean(PrototypeBean prototypeBean) {
            this.prototypeBean = prototypeBean;
        }

        public int logic() {
            prototypeBean.addCount();
            int count = prototypeBean.getCount();
            return count;
        }
    }


    // "prototype"으로 사용자 정의 범위인 PrototypeBean을 정의합니다.
    @Scope("prototype")
    static class PrototypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        // 빈이 생성된 후 실행되는 메서드입니다.
        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init " + this);
        }

        // 빈이 파괴되기 전 실행되는 메서드입니다.
        @PreDestroy
        public void destroy() {
            System.out.println("PrototypeBean.destroy");
        }
    }
}