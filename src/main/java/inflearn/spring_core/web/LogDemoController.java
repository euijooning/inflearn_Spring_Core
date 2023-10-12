package inflearn.spring_core.web;

import inflearn.spring_core.common.MyLogger;
import inflearn.spring_core.logdemo.LogDemoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {

        String requestURL = request.getRequestURL().toString(); //고객이 어떤 URL로 보냈는지를 추출
        myLogger.setRequestURL(requestURL); // URL 세팅 완료

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}