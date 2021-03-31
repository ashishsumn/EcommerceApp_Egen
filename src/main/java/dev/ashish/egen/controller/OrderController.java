package dev.ashish.egen.controller;

import dev.ashish.egen.model.Delivery;
import dev.ashish.egen.model.Order;
import dev.ashish.egen.model.OrderDetails;
import dev.ashish.egen.model.Product;
import dev.ashish.egen.service.DeliveryService;
import dev.ashish.egen.service.OrderService;
import dev.ashish.egen.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/egen")
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;
    private final DeliveryService deliveryService;

    public OrderController(OrderService orderService, ProductService productService, DeliveryService deliveryService) {
        this.orderService = orderService;
        this.productService = productService;
        this.deliveryService = deliveryService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAllOrders () {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable("id") Long id) {
        Order order = orderService.findOrderByOrderId(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDetails orderDetails) {
        Order newOrder = orderService.processOrder(orderDetails);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PostMapping("/addDeliveryMethod")
    public ResponseEntity<Delivery> addDeliveryMethod(@RequestBody Delivery delivery) {
        Delivery newDelivery = deliveryService.addDeliveryMethod(delivery);
        return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);
    }
}
