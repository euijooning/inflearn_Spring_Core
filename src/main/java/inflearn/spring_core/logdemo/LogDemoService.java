package inflearn.spring_core.logdemo;

import inflearn.spring_core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final ObjectProvider<MyLogger> myLoggerProvider; // 여기

    public void logic(String id) {
        MyLogger myLogger = myLoggerProvider.getObject(); // 이거 추가
        myLogger.log("service id = " + id);
    }
}