package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@IdClass(OrderProductId.class)
public class OrderItems implements Serializable {

    @Id
    private Long orderId;
    @Id
    private Long productId;
    private int orderItemQty;

    public OrderItems() {}

    public OrderItems(Long orderId, Long productId, int orderItemQty) {
        this.orderId = orderId;
        this.productId = productId;
        this.orderItemQty = orderItemQty;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public int getOrderItemQty() {
        return orderItemQty;
    }

    public void setOrderItemQty(int orderItemQty) {
        this.orderItemQty = orderItemQty;
    }
}