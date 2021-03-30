package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderShipping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long shippingId;
    private String orderShippingAddressline1;
    private String orderShippingAddressline2;
    private String orderShippingCity;
    private String orderShippingState;
    private int orderShippingZip;
    private int deliveryCode;

    public OrderShipping() {}

    public OrderShipping(String orderShippingAddressline1, String orderShippingAddressline2, String orderShippingCity,
                         String orderShippingState, int orderShippingZip, int deliveryCode) {
        this.orderShippingAddressline1 = orderShippingAddressline1;
        this.orderShippingAddressline2 = orderShippingAddressline2;
        this.orderShippingCity = orderShippingCity;
        this.orderShippingState = orderShippingState;
        this.orderShippingZip = orderShippingZip;
        this.deliveryCode = deliveryCode;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public String getOrderShippingAddressline1() {
        return orderShippingAddressline1;
    }

    public void setOrderShippingAddressline1(String orderShippingAddressline1) {
        this.orderShippingAddressline1 = orderShippingAddressline1;
    }

    public String getOrderShippingAddressline2() {
        return orderShippingAddressline2;
    }

    public void setOrderShippingAddressline2(String orderShippingAddressline2) {
        this.orderShippingAddressline2 = orderShippingAddressline2;
    }

    public String getOrderShippingCity() {
        return orderShippingCity;
    }

    public void setOrderShippingCity(String orderShippingCity) {
        this.orderShippingCity = orderShippingCity;
    }

    public String getOrderShippingState() {
        return orderShippingState;
    }

    public void setOrderShippingState(String orderShippingState) {
        this.orderShippingState = orderShippingState;
    }

    public int getOrderShippingZip() {
        return orderShippingZip;
    }

    public void setOrderShippingZip(int orderShippingZip) {
        this.orderShippingZip = orderShippingZip;
    }

    public int getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(int deliveryCode) {
        this.deliveryCode = deliveryCode;
    }
}
