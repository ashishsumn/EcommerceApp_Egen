package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long billingId;
    private String orderBillingAddressline1;
    private String orderBillingAddressline2;
    private String orderBillingCity;
    private String orderBillingState;
    private int orderBillingZip;

    public Billing() {}

    public Billing(String orderBillingAddressline1, String orderBillingAddressline2, String orderBillingCity, String orderBillingState, int orderBillingZip) {
        this.orderBillingAddressline1 = orderBillingAddressline1;
        this.orderBillingAddressline2 = orderBillingAddressline2;
        this.orderBillingCity = orderBillingCity;
        this.orderBillingState = orderBillingState;
        this.orderBillingZip = orderBillingZip;
    }

    public Long getBillingId() {
        return billingId;
    }

    public String getOrderBillingAddressline1() {
        return orderBillingAddressline1;
    }

    public void setOrderBillingAddressline1(String orderBillingAddressline1) {
        this.orderBillingAddressline1 = orderBillingAddressline1;
    }

    public String getOrderBillingAddressline2() {
        return orderBillingAddressline2;
    }

    public void setOrderBillingAddressline2(String orderBillingAddressline2) {
        this.orderBillingAddressline2 = orderBillingAddressline2;
    }

    public String getOrderBillingCity() {
        return orderBillingCity;
    }

    public void setOrderBillingCity(String orderBillingCity) {
        this.orderBillingCity = orderBillingCity;
    }

    public String getOrderBillingState() {
        return orderBillingState;
    }

    public void setOrderBillingState(String orderBillingState) {
        this.orderBillingState = orderBillingState;
    }

    public int getOrderBillingZip() {
        return orderBillingZip;
    }

    public void setOrderBillingZip(int orderBillingZip) {
        this.orderBillingZip = orderBillingZip;
    }
}
