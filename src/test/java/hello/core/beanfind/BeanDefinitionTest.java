package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * packageName    : hello.core.beanfind
 * fileName       : BeanDefinitionTest
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class BeanDefinitionTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    GenericXmlApplicationContext gxac = new GenericXmlApplicationContext("appConfig.xml"); // AnnotionConfigApplicationContext로 호출하면 getBeanDefinition이 안됨

    @Test
    @DisplayName("빈 설정 메타정보 확인")
    void findApplicationBean() {
        String[] beanDefinitionNames = gxac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = gxac.getBeanDefinition(beanDefinitionName);
            
            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                System.out.println("beanDefinitionName = " + beanDefinitionName + " beanDefinition = " + beanDefinition);
            }
        }
    }
}
