package hello.core.order;

/**
 * packageName    : hello.core.order
 * fileName       : OrderService
 * author         : yoons
 * date           : 2025-01-11
 * description    :
 */
public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
