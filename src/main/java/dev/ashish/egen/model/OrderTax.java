package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderTax implements Serializable {

    @Id
    @Column(nullable = false, updatable = false)
    private Long order_id;
    private double order_tax;

    public OrderTax() {}

    public OrderTax(Long order_id, double order_tax){
        this.order_id = order_id;
        this.order_tax = order_tax;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public double getOrder_tax() {
        return order_tax;
    }

    public void setOrder_tax(double order_tax) {
        this.order_tax = order_tax;
    }
}
