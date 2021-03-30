package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long payment_id;
    private Long order_id;
    private String payment_method;
    private Date payment_date;
    private int payment_confirmation_number;

    public Payment() {}

    public Payment(Long order_id, String payment_method, Date payment_date, int payment_confirmation_number){
        this.order_id = order_id;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.payment_confirmation_number = payment_confirmation_number;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Date getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(Date payment_date) {
        this.payment_date = payment_date;
    }

    public int getPayment_confirmation_number() {
        return payment_confirmation_number;
    }

    public void setPayment_confirmation_number(int payment_confirmation_number) {
        this.payment_confirmation_number = payment_confirmation_number;
    }

}
