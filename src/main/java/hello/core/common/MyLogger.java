package hello.core.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * packageName    : hello.core.common
 * fileName       : MyLogger
 * author         : yoons
 * date           : 2025-02-12
 * description    : 해당 Component를 Controller에 DI하면 오류가 난다
 *                  의존성 주입은 빈이 생성된 후에 발생하는데 scope가 request가 되면 고객의 http 호출이 와야 bean이 생성되기 때문!
 *                  그래서 Provider로 bean 생성을 lazy해서 해결한다.
 *                  Provider를 안쓰려면 ScopeProxyMode를 설정하여 가짜 빈을 만들어주면서 해결한다
 */
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String message) {
        System.out.println("[" + uuid + "]" + "[" + requestURL + "] " + message);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid + "] request scope bean create:" + this);
    }

    @PreDestroy
    public void close() {
        System.out.println("[" + uuid + "] request scope bean close:" + this);
    }
}
