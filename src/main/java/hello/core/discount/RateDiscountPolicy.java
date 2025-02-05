package hello.core.discount;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

/**
 * packageName    : hello.core.discount
 * fileName       : RateDiscountPolicy
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
@Component
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (Grade.VIP == member.getGrade()) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
