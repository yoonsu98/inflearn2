package hello.core.scan.filter;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * packageName    : hello.core.scan.filter
 * fileName       : MyExcludeComponent
 * author         : yoons
 * date           : 2025-01-15
 * description    :
 */
@Target(ElementType.TYPE) //class 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
