package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : hello.core.scan
 * fileName       : AutoAppConfigTest
 * author         : yoons
 * date           : 2025-01-15
 * description    :
 */
public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService bean = applicationContext.getBean(MemberService.class);
        Assertions.assertThat(bean).isInstanceOf(MemberService.class);
    }
}
