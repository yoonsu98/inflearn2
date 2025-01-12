package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName    : hello.core.singleton
 * fileName       : StatefulServiceTest
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService = ac.getBean(StatefulService.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        
        // ThreadA : A사용자 10000원 주문
        int userA = statefulService.order("userA", 10000);

        // ThreadB : B사용자 20000원 주문
        int userB = statefulService1.order("userB", 20000);

        Assertions.assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {
        
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}