package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long paymentId;
    private Long orderId;
    private String paymentMethod;
    private Date paymentDate;
    private int paymentConfirmationNumber;
    private Long billingId;

    public Payment() {}

    public Payment(Long orderId, String paymentMethod, Date paymentDate, int paymentConfirmationNumber, Long billingId) {
        this.orderId = orderId;
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.billingId = billingId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getPaymentConfirmationNumber() {
        return paymentConfirmationNumber;
    }

    public void setPaymentConfirmationNumber(int paymentConfirmationNumber) {
        this.paymentConfirmationNumber = paymentConfirmationNumber;
    }

    public Long getBillingId() {
        return billingId;
    }

    public void setBillingId(Long billingId) {
        this.billingId = billingId;
    }
}
