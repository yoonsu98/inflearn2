package hello.core.discount;

import hello.core.member.Member;

/**
 * packageName    : hello.core.discount
 * fileName       : DiscountPolicy
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);


}
