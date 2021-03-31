package dev.ashish.egen.repo;

import dev.ashish.egen.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepo extends JpaRepository<Delivery, Integer> {
    void deleteDeliveryByDeliveryCode(int id);
}
