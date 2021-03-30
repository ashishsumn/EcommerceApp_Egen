package dev.ashish.egen.service;

import dev.ashish.egen.exceptions.OrderNotFoundException;
import dev.ashish.egen.model.*;
import dev.ashish.egen.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepo orderRepo;
    private final OrderItemsRepo orderItemsRepo;
    private final OrderShippingRepo orderShippingRepo;
    private final BillingRepo billingRepo;
    private final PaymentRepo paymentRepo;
    private final OrderTaxRepo orderTaxRepo;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepo orderRepo, OrderItemsRepo orderItemsRepo, OrderShippingRepo orderShippingRepo,
                        BillingRepo billingRepo, PaymentRepo paymentRepo, OrderTaxRepo orderTaxRepo, ProductService productService){
        this.orderRepo = orderRepo;
        this.orderItemsRepo = orderItemsRepo;
        this.orderShippingRepo = orderShippingRepo;
        this.billingRepo = billingRepo;
        this.paymentRepo = paymentRepo;
        this.orderTaxRepo = orderTaxRepo;
        this.productService = productService;
    }

    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    public OrderItems addOrderItem(OrderItems orderItems) {
        return orderItemsRepo.save(orderItems);
    }

    public OrderShipping addOrderShipping(OrderShipping orderShipping) {
        return orderShippingRepo.save(orderShipping);
    }

    public Billing addBillingDetails(Billing billing){
        return billingRepo.save(billing);
    }

    public Payment addPaymentDetails(Payment payment){
        return paymentRepo.save(payment);
    }

    public OrderTax addOrderTaxDetails(OrderTax orderTax){
        return orderTaxRepo.save(orderTax);
    }

    public List<Order> findAllOrders() {
        return orderRepo.findAll();
    }

    public Order updateOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order findOrderByOrderId(Long id) {
        return orderRepo.findOrderByOrderId(id)
                .orElseThrow(() -> new OrderNotFoundException("Order by id " + id + " was not found"));
    }

    public Product findProductByProductId(Long id) {
        return productService.findProductByProductId(id);
    }

    public void deleteOrder(Long id){
        orderRepo.deleteOrderByOrderId(id);
    }

    public Order processOrder(OrderDetails orderDetails){

        //populating shipping table
        OrderShipping orderShipping = this.addOrderShipping(new OrderShipping(orderDetails.getOrderShippingAddressline1(),
                orderDetails.getOrderShippingAddressline2(), orderDetails.getOrderShippingCity(),
                orderDetails.getOrderShippingState(), orderDetails.getOrderShippingZip(), orderDetails.getDeliveryCode()));

        //populating orders table
        List<OrderItems> itemList=  orderDetails.getOrderItemList();
        System.out.println(itemList.size());
        int subTotal = 0;
        for(OrderItems orderItems : itemList){
            System.out.println(orderItems.getProductId());
            Product product = this.findProductByProductId(orderItems.getProductId());
            subTotal += product.getProductPrice();
        }
        Order newOrder = this.addOrder(new Order(orderDetails.getOrderStatus(), orderDetails.getOrderCustomerId(),
                orderDetails.getCreatedDate(), orderDetails.getModifiedDate(), subTotal,
                orderShipping.getShippingId()));

        //populating order_items table
        itemList=  orderDetails.getOrderItemList();
        for(OrderItems orderItems : itemList){
            this.addOrderItem(new OrderItems(newOrder.getOrderId(), orderItems.getProductId(), orderItems.getOrderItemQty()));
        }

        //populating billing and Payment table
        List<PaymentAndBillingDetails> paymentAndBillingDetailsList=  orderDetails.getPaymentAndBillingDetailsList();
        for(PaymentAndBillingDetails paymentAndBillingDetails : paymentAndBillingDetailsList){
            Billing billing = this.addBillingDetails(new Billing(paymentAndBillingDetails.getOrderBillingAddressline1(),
                    paymentAndBillingDetails.getOrderBillingAddressline2(), paymentAndBillingDetails.getOrderBillingCity(),
                    paymentAndBillingDetails.getOrderBillingState(), paymentAndBillingDetails.getOrderBillingZip()));

            Payment payment = this.addPaymentDetails(new Payment(newOrder.getOrderId(), paymentAndBillingDetails.getOrderPaymentMethod(),
                    paymentAndBillingDetails.getOrderPaymentDate(), paymentAndBillingDetails.getOrderPaymentConfirmationNumber(),
                    billing.getBillingId()));
        }

        //populating orderTax table
        OrderTax orderTax = this.addOrderTaxDetails(new OrderTax(newOrder.getOrderId(), this.calculateTax(newOrder.getOrderSubtotal())));

        return newOrder;
    }

    private double calculateTax(double orderSubtotal){
        return orderSubtotal*0.2;
    }
}
