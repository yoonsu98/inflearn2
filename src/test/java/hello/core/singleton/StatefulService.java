package hello.core.singleton;

/**
 * packageName    : hello.core.singleton
 * fileName       : StatefulService
 * author         : yoons
 * date           : 2025-01-12
 * description    :
 */
public class StatefulService {

//    private int price;

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
//        this.price = price;
        return price;
    }
}
