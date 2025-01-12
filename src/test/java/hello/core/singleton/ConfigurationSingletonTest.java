package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * packageName    : hello.core.singleton
 * fileName       : ConfigurationSingletonTest
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository1 = memberService.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

        assertThat(memberRepository1).isSameAs(memberRepository2);

        // call AppConfig.memberRepository
        // call AppConfig.memberService
        // call AppConfig.orderService
        // AppConfig에서는 memberRepository가 3번이 호출되는데 실제로 실행하면 1번만 호출되는 것을 알 수 있다.
        // 그 이유는 AppConfig도 @Configuration이라는 어노테이션이 붙은 객체인 것.
        // AppConfig를 실행할 때 proxy가 AppConfig 대신 실행해서 memberRepository() 객체가 생성되었는지 확인해서 없으면 new, 있으면 그냥 반환 (예시일 뿐, 실제는 다를 수 있음)
    }
    
    @Test
    void configurationDeep() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        AppConfig bean = ac.getBean(AppConfig.class);

        System.out.println("bean.getClass() = " + bean.getClass());
    }
}
