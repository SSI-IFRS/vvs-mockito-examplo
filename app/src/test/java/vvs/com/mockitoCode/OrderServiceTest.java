package vvs.com.mockitoCode;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;
    private AutoCloseable closeable;
    private OrderService orderService;

    @BeforeEach
    void initService() {
        // orderRepository = mock(OrderRepository.class);
        closeable = MockitoAnnotations.openMocks(this);
        orderService = new OrderService(orderRepository);
    }

    @AfterEach
    void closeService() throws Exception {
        closeable.close();
    }

    @Test
    void createOrderSetsTheCreationDate() {
        Order order = new Order();
        
        when(orderRepository.save(any(Order.class))).then(returnsFirstArg());

        Order saveOrder = orderService.create(order);

        assertNotNull(saveOrder.getCreationDate());
    }
    
}
