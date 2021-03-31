package dev.ashish.egen;

import dev.ashish.egen.controller.OrderController;
import dev.ashish.egen.model.Order;
import dev.ashish.egen.service.OrderService;
import org.assertj.core.util.DateUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class JUnitControllerTest {

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    /*
     * Unit test for getOrderById
     * */
    @Test
    public void testGetOrderById() {
        Order order = new Order();
        order.setOrderId(1l);
        // stubbing the orderService.findOrderByOrderId() response
        when(orderService.findOrderByOrderId(1l)).thenReturn(order);
        ResponseEntity<Order> orderReturned = orderController.getOrderById(1L);
        // check to see if the stubbed method is actually called
        verify(orderService).findOrderByOrderId(1l);
        assertEquals(1l, orderReturned.getBody().getOrderId().longValue());
    }

    /*
     * Unit test for getAllOrders
     * */
    @Test
    public void testGetAllOrders() {
        Order order1 = new Order("placed", "axsdf33",
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
        500, 2l);
        Order order2 = new Order("delivered", "seddsww1111",
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
                DateUtil.parseDatetime("2021-03-31T15:37:41.103+00:00"),
                500, 2l);
        List<Order> allOrders = Arrays.asList(order1,order2);
        when(orderService.findAllOrders()).thenReturn(allOrders);
        ResponseEntity<List<Order>> order = orderController.getAllOrders();
        verify(orderService).findAllOrders();
        assertEquals(2, Objects.requireNonNull(order.getBody()).size());
    }
}
