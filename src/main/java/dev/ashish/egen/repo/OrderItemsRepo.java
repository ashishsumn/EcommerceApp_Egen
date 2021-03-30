package dev.ashish.egen.repo;

import dev.ashish.egen.model.OrderItems;
import dev.ashish.egen.model.OrderProductId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemsRepo extends JpaRepository<OrderItems, OrderProductId> {
}
