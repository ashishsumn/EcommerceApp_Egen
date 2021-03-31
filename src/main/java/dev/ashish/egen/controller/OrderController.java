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

    /* **********Order methods :: STARTS *************** */

    /*
     * Method to Add/create a new order
     * */
    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder(@RequestBody OrderDetails orderDetails) {
        Order newOrder = orderService.processOrder(orderDetails);
        return new ResponseEntity<>(newOrder, HttpStatus.CREATED);
    }

    /*
     * Method to Fetch all orders
     * */
    @GetMapping("/allOrders")
    public ResponseEntity<List<Order>> getAllOrders () {
        List<Order> orders = orderService.findAllOrders();
        return new ResponseEntity<>(orders, HttpStatus.OK);
    }

    /*
     * Method to Fetch a single order using orderId
     * */
    @GetMapping("/findOrder/{id}")
    public ResponseEntity<Order> getOrderById (@PathVariable("id") Long id) {
        Order order = orderService.findOrderByOrderId(id);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    /*
     * Method to Update an existing order
     * */
    @PutMapping("/updateOrder")
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        Order updateOrder = orderService.updateOrder(order);
        return new ResponseEntity<>(updateOrder, HttpStatus.OK);
    }

    /* Method to hard delete an order.
     * Note: Though we have a method to hard delete an order, always prefer to soft delete an order by updating
     * the status in 'Orders' table to "CANCELLED"
     */
    @DeleteMapping("/deleteOrder/{id}")
    public ResponseEntity<?> deleteOrder(@PathVariable("id") Long id) {
        orderService.deleteOrder(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* **********Order methods :: ENDS *************** */

    /* **********Product methods :: STARTS *************** */

    /*
     * Method to Add a new product in inventory
     * */
    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    /*
     * Method to Fetch all products
     * */
    @GetMapping("/allProducts")
    public ResponseEntity<List<Product>> getAllProducts () {
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    /*
     * Method to Fetch a single product using productId
     * */
    @GetMapping("/findProduct/{id}")
    public ResponseEntity<Product> getProductById (@PathVariable("id") Long id) {
        Product product = productService.findProductByProductId(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    /*
     * Method to Update an existing product
     * */
    @PutMapping("/updateProduct")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

    /*
     * Method to Delete a product
     * */
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* **********Product methods :: ENDS *************** */


    /* **********Delivery methods :: STARTS *************** */

    /* Method to Add a new delivery method
     * e.g. In-store pickup, curbside delivery, ship to home, 3rd party delivery
     */
    @PostMapping("/addDeliveryMethod")
    public ResponseEntity<Delivery> addDeliveryMethod(@RequestBody Delivery delivery) {
        Delivery newDelivery = deliveryService.addDeliveryMethod(delivery);
        return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);
    }

    /*
     * Method to Delete a delivery method
     * */
    @DeleteMapping("/deleteDeliveryMethod/{id}")
    public ResponseEntity<?> deleteDeliveryMethod(@PathVariable("id") int id) {
        deliveryService.deleteDeliveryMethod(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /* **********Delivery methods :: ENDS *************** */
}
