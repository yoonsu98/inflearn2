package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

/**
 * packageName    : hello.core.discount
 * fileName       : FixDiscountPolicy
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
@Component
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        if (Grade.VIP == member.getGrade()) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
