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

    /* ********* Repository methods :: START *************** */

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

    /* ********* Repository methods :: END *************** */

    /*
    * Method to process an order
    * */
    public Order processOrder(OrderDetails orderDetails){

        //populating shipping table
        OrderShipping orderShipping = populateOrderShippingTable(orderDetails);

        //populating orders table
        double subTotal = calculateOrderSubTotal(orderDetails);
        Order order = populateOrderTable(orderDetails, subTotal, orderShipping.getShippingId());

        //populating order_items table
        populateOrderItemsTable(orderDetails, order.getOrderId());

        //populating billing and Payment table
        List<PaymentAndBillingDetails> paymentAndBillingDetailsList=  orderDetails.getPaymentAndBillingDetailsList();
        for(PaymentAndBillingDetails paymentAndBillingDetails : paymentAndBillingDetailsList){
            Billing billing = populateBillingTable(paymentAndBillingDetails);
            Payment payment = populatePaymentTable(paymentAndBillingDetails, order.getOrderId(), billing.getBillingId());
        }

        //populating orderTax table
        populateOrderTaxTable(order.getOrderId(), order.getOrderSubtotal());

        return order;
    }

    /*
     * Method to populate order_shipping table
     * */
    private OrderShipping populateOrderShippingTable(OrderDetails orderDetails){
        return this.addOrderShipping(new OrderShipping(orderDetails.getOrderShippingAddressline1(),
                orderDetails.getOrderShippingAddressline2(), orderDetails.getOrderShippingCity(),
                orderDetails.getOrderShippingState(), orderDetails.getOrderShippingZip(), orderDetails.getDeliveryCode()));
    }

    /*
     * Method to calculate subtotal for an order
     * */
    private double calculateOrderSubTotal(OrderDetails orderDetails){
        List<OrderItems> itemList=  orderDetails.getOrderItemList();
        int subTotal = 0;
        for(OrderItems orderItems : itemList){
            System.out.println(orderItems.getProductId());
            Product product = this.findProductByProductId(orderItems.getProductId());
            subTotal += product.getProductPrice() * orderItems.getOrderItemQty();
        }
        return subTotal;
    }

    /*
     * Method to populate order table
     * */
    private Order populateOrderTable(OrderDetails orderDetails, double subTotal, Long shippingId){
        return this.addOrder(new Order(orderDetails.getOrderStatus(), orderDetails.getOrderCustomerId(),
                orderDetails.getCreatedDate(), orderDetails.getModifiedDate(), subTotal, shippingId));
    }

    /*
     * Method to populate order_items table
     * */
    private void populateOrderItemsTable(OrderDetails orderDetails, Long orderId){
        List<OrderItems> itemList=  orderDetails.getOrderItemList();
        for(OrderItems orderItems : itemList){
            this.addOrderItem(new OrderItems(orderId, orderItems.getProductId(), orderItems.getOrderItemQty()));
        }
    }

    /*
     * Method to populate billing table
     * */
    private Billing populateBillingTable(PaymentAndBillingDetails paymentAndBillingDetails){
        return this.addBillingDetails(new Billing(paymentAndBillingDetails.getOrderBillingAddressline1(),
                paymentAndBillingDetails.getOrderBillingAddressline2(), paymentAndBillingDetails.getOrderBillingCity(),
                paymentAndBillingDetails.getOrderBillingState(), paymentAndBillingDetails.getOrderBillingZip()));
    }

    /*
     * Method to populate payment table
     * */
    private Payment populatePaymentTable(PaymentAndBillingDetails paymentAndBillingDetails, Long orderId, Long billingId){
        return this.addPaymentDetails(new Payment(orderId, paymentAndBillingDetails.getPaymentMethod(),
                paymentAndBillingDetails.getPaymentDate(), paymentAndBillingDetails.getPaymentConfirmationNumber(),
                billingId));
    }

    /*
     * Method to populate order_tax table
     * */
    private void populateOrderTaxTable(Long orderId, double subTotal){
        this.addOrderTaxDetails(new OrderTax(orderId, this.calculateTax(subTotal)));
    }

    /*
     * Method to calculate tax for an order
     * Note: Remove hardcoding for the tax rate and move it to a config file
     * */
    private double calculateTax(double orderSubtotal){
        double taxRate = 0.2;
        return orderSubtotal*taxRate;
    }
}
