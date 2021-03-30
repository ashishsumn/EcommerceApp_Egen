package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long orderId;
    private String orderStatus;
    private String orderCustomerId;
    private Date createdDate;
    private Date modifiedDate;
    private double orderSubtotal;
    private Long shippingId;

    public Order() {}

    public Order(String orderStatus, String orderCustomerId, Date createdDate, Date modifiedDate,
                 double orderSubtotal, Long shippingId){
        this.orderStatus = orderStatus;
        this.orderCustomerId = orderCustomerId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.orderSubtotal = orderSubtotal;
        this.shippingId = shippingId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getOrderCustomerId() {
        return orderCustomerId;
    }

    public void setOrderCustomerId(String orderCustomerId) {
        this.orderCustomerId = orderCustomerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public double getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(double orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public Long getShippingId() {
        return shippingId;
    }

    public void setShippingId(Long shippingId) {
        this.shippingId = shippingId;
    }
}
