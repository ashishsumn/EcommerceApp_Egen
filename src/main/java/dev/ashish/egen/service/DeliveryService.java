package dev.ashish.egen.service;

import dev.ashish.egen.exceptions.ProductNotFoundException;
import dev.ashish.egen.model.Delivery;
import dev.ashish.egen.model.Product;
import dev.ashish.egen.repo.DeliveryRepo;
import dev.ashish.egen.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DeliveryService {

    private final DeliveryRepo deliveryRepo;

    @Autowired
    public DeliveryService(DeliveryRepo deliveryRepo){
        this.deliveryRepo = deliveryRepo;
    }

    public Delivery addDeliveryMethod(Delivery delivery) {
        return deliveryRepo.save(delivery);
    }

    public List<Delivery> findAllDeliveryMethods() {
        return deliveryRepo.findAll();
    }

    public void deleteDeliveryMethod(int id){
        deliveryRepo.deleteDeliveryByDeliveryCode(id);
    }

}
