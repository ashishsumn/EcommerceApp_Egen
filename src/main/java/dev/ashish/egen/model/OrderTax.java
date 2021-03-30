package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderTax implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private Long orderId;
    private double orderTax;

    public OrderTax() {}

    public OrderTax(Long orderId, double orderTax) {
        this.orderId = orderId;
        this.orderTax = orderTax;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }
}
