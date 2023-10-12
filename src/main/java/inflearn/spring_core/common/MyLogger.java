package inflearn.spring_core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

// 스프링 빈으로 등록되는 클래스를 나타내는 어노테이션
@Component
// 스프링 빈의 스코프를 "request"로 지정
@Scope(value = "request")
public class MyLogger {
    private String uuid; // UUID를 저장하는 변수
    private String requestURL; // HTTP 요청의 URL을 저장하는 변수

    // 외부에서 HTTP 요청의 URL을 설정하는 메서드
    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    // 로그 메시지를 출력하는 메서드
    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " +
                message);
    }

    // 빈 초기화 시 UUID를 생성하고 초기화 메시지를 출력하는 메서드
    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString(); // UUID 생성
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    // 빈 소멸 시 소멸 메시지를 출력하는 메서드
    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}