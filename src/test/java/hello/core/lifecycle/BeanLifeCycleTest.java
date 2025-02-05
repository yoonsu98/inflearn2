package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * packageName    : hello.core.lifecycle
 * fileName       : BeanLifeCycleTest
 * author         : yoons
 * date           : 2025-02-05
 * description    :
 */
public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = ac.getBean(NetworkClient.class);

        ac.close(); //필수
    }

    @Configuration
    static class LifeCycleConfig {
        //destroyMethod는 close나 shutdown의 메소드명을 자동으로 호출해준다...!!!
//        @Bean(initMethod = "init")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
