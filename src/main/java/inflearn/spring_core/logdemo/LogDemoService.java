package inflearn.spring_core.logdemo;

import inflearn.spring_core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger; // 여기

    public void logic(String id) {
        myLogger.log("service id = " + id); // 여기
    }
}