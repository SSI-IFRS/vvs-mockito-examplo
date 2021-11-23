package vvs.com.mockitoCode;

import java.time.LocalDateTime;

public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        order.setCreationDate(LocalDateTime.now());
        return orderRepository.save(order);
    }
}
