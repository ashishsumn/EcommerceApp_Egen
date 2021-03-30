package dev.ashish.egen.repo;

import dev.ashish.egen.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {

    void deleteOrderByOrderId(Long order_id);

    Optional<Order> findOrderByOrderId(Long order_id);
}
