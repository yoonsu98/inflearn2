package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * packageName    : hello.core.singleton
 * fileName       : SingletonTest
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService = appConfig.memberService();

        //2. 조회 : 호출할 때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isNotSameAs(memberService);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 생성")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        Assertions.assertThat(instance).isSameAs(instance2);
        // sameas : instance가 같은지
        // equal : 문자열이 같은지
    }
    
    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
//        AppConfig appConfig = new AppConfig();
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        //1. 조회 : 호출할 때 마다 객체를 생성
//        MemberService memberService = appConfig.memberService();
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        //2. 조회 : 호출할 때마다 객체를 생성
//        MemberService memberService1 = appConfig.memberService();
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService1 = " + memberService1);

        Assertions.assertThat(memberService1).isSameAs(memberService);
    }
}
