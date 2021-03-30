package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long order_id;
    private String order_status;
    @Column(nullable = false, updatable = false)
    private String order_customer_id;
    @Column(nullable = false, updatable = false)
    private Date created_date;
    private Date modified_date;
    private double order_subtotal;
    private int shipping_id;

    public Order() {}

    public Order(String order_status, String order_customer_id, Date created_date, Date modified_date,
                 double order_subtotal, int shipping_id){
        this.order_status = order_status;
        this.order_customer_id = order_customer_id;
        this.created_date = created_date;
        this.modified_date = modified_date;
        this.order_subtotal = order_subtotal;
        this.shipping_id = shipping_id;
    }

    public String getOrder_status() {
        return order_status;
    }

    public void setOrder_status(String order_status) {
        this.order_status = order_status;
    }

    public String getOrder_customer_id() {
        return order_customer_id;
    }

    public void setOrder_customer_id(String order_customer_id) {
        this.order_customer_id = order_customer_id;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Date getModified_date() {
        return modified_date;
    }

    public void setModified_date(Date modified_date) {
        this.modified_date = modified_date;
    }

    public double getOrder_subtotal() {
        return order_subtotal;
    }

    public void setOrder_subtotal(double order_subtotal) {
        this.order_subtotal = order_subtotal;
    }

    public int getShipping_id() {
        return shipping_id;
    }

    public void setShipping_id(int shipping_id) {
        this.shipping_id = shipping_id;
    }

    /*    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", phone='" + phone + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }*/
}
