package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * packageName    : hello.core
 * fileName       : HelloLombok
 * author         : yoons
 * date           : 2025-02-01
 * description    :
 */
@Getter
@Setter
@ToString
public class HelloLombok {
    
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("가나다라");
        
        String name = helloLombok.getName();
        System.out.println("name = " + name);

        System.out.println("helloLombok = " + helloLombok);
    }
}
