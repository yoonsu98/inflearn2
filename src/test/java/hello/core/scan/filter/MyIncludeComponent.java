package hello.core.scan.filter;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * packageName    : hello.core.scan.filter
 * fileName       : MyIncludeComponent
 * author         : yoons
 * date           : 2025-01-15
 * description    :
 */
@Target(ElementType.TYPE) //class 레벨에 붙음
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Indexed
public @interface MyIncludeComponent {
}
