package inflearn.spring_core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //설정 정보
@ComponentScan( // @Component 붙은 자동으로 컴포넌트 정보들을 끌어오는 것
        excludeFilters = @Filter(type = FilterType.ANNOTATION, // 그 중에서 뺄 것 @Bean붙은건 수동으로 등록해놓은거니까
        classes = Configuration.class)
)
public class AutoAppConfig {

}
