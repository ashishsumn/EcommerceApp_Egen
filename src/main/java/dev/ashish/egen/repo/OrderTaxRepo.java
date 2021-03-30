package dev.ashish.egen.repo;

import dev.ashish.egen.model.OrderTax;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTaxRepo extends JpaRepository<OrderTax, Long> {
}
