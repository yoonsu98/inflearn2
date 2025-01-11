package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : hello.core.beanfind
 * fileName       : ApplicationContextBasicFindTest
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBeans() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName + "object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            // 개발하기 위한 빈을 등록한 것 + 외부 라이브러리
            if (BeanDefinition.ROLE_APPLICATION == beanDefinition.getRole()) {
                System.out.println("ROLE_APPLICATION beanDefinitionName = " + beanDefinitionName + "object = " + bean);
            }
            // 스프링이 내부에서 사용하는 빈
            if (BeanDefinition.ROLE_INFRASTRUCTURE == beanDefinition.getRole()) {
                System.out.println("ROLE_INFRASTRUCTURE beanDefinitionName = " + beanDefinitionName + "object = " + bean);
            }
        }
    }
}
