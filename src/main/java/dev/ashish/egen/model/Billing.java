package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long billing_id;
    private String order_billing_addressline1;
    private String order_billing_addressline2;
    private String order_billing_city;
    private String order_billing_state;
    private int order_billing_zip;

    public Billing() {}

    public Billing(String order_billing_addressline1, String order_billing_addressline2,
                         String order_billing_city, String order_billing_state, int order_billing_zip){
        this.order_billing_addressline1 = order_billing_addressline1;
        this.order_billing_addressline2 = order_billing_addressline2;
        this.order_billing_city = order_billing_city;
        this.order_billing_state = order_billing_state;
        this.order_billing_zip = order_billing_zip;
    }

    public String getOrder_billing_addressline1() {
        return order_billing_addressline1;
    }

    public void setOrder_billing_addressline1(String order_billing_addressline1) {
        this.order_billing_addressline1 = order_billing_addressline1;
    }

    public String getOrder_billing_addressline2() {
        return order_billing_addressline2;
    }

    public void setOrder_billing_addressline2(String order_billing_addressline2) {
        this.order_billing_addressline2 = order_billing_addressline2;
    }

    public String getOrder_billing_city() {
        return order_billing_city;
    }

    public void setOrder_billing_city(String order_billing_city) {
        this.order_billing_city = order_billing_city;
    }

    public String getOrder_billing_state() {
        return order_billing_state;
    }

    public void setOrder_billing_state(String order_billing_state) {
        this.order_billing_state = order_billing_state;
    }

    public int getOrder_billing_zip() {
        return order_billing_zip;
    }

    public void setOrder_billing_zip(int order_billing_zip) {
        this.order_billing_zip = order_billing_zip;
    }
}
