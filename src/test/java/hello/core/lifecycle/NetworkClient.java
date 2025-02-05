package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * packageName    : hello.core.lifecycle
 * fileName       : NetworkClient
 * author         : yoons
 * date           : 2025-02-05
 * description    :
 */
public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작 시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }
    
    public void call(String message) {
        System.out.println("call: " + url + ", message : " + message);
    }

    //서비스 종료 시 호출
    public void disconnect() {
        System.out.println("close " + url);
    }

    @PostConstruct
    //의존관계 주입 끝나면 호출됨
    public void init() throws Exception {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    //소멸
    public void close() throws Exception {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
