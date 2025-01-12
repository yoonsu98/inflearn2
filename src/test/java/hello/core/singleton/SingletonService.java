package hello.core.singleton;

/**
 * packageName    : hello.core.singleton
 * fileName       : SingletonService
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");

    }
}
