package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderShipping implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long shipping_id;
    private String order_shipping_addressline1;
    private String order_shipping_addressline2;
    private String order_shipping_city;
    private String order_shipping_state;
    private int order_shipping_zip;
    private int delivery_code;

    public OrderShipping() {}

    public OrderShipping(String order_shipping_addressline1, String order_shipping_addressline2,
                         String order_shipping_city, String order_shipping_state, int order_shipping_zip,
                         int delivery_code){
        this.order_shipping_addressline1 = order_shipping_addressline1;
        this.order_shipping_addressline2 = order_shipping_addressline2;
        this.order_shipping_city = order_shipping_city;
        this.order_shipping_state = order_shipping_state;
        this.order_shipping_zip = order_shipping_zip;
        this.delivery_code = delivery_code;
    }

    public String getOrder_shipping_addressline1() {
        return order_shipping_addressline1;
    }

    public void setOrder_shipping_addressline1(String order_shipping_addressline1) {
        this.order_shipping_addressline1 = order_shipping_addressline1;
    }

    public String getOrder_shipping_addressline2() {
        return order_shipping_addressline2;
    }

    public void setOrder_shipping_addressline2(String order_shipping_addressline2) {
        this.order_shipping_addressline2 = order_shipping_addressline2;
    }

    public String getOrder_shipping_city() {
        return order_shipping_city;
    }

    public void setOrder_shipping_city(String order_shipping_city) {
        this.order_shipping_city = order_shipping_city;
    }

    public String getOrder_shipping_state() {
        return order_shipping_state;
    }

    public void setOrder_shipping_state(String order_shipping_state) {
        this.order_shipping_state = order_shipping_state;
    }

    public int getOrder_shipping_zip() {
        return order_shipping_zip;
    }

    public void setOrder_shipping_zip(int order_shipping_zip) {
        this.order_shipping_zip = order_shipping_zip;
    }

    public int getDelivery_code() {
        return delivery_code;
    }

    public void setDelivery_code(int delivery_code) {
        this.delivery_code = delivery_code;
    }
}
