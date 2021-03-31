package dev.ashish.egen.model;

import java.util.Date;

public class PaymentAndBillingDetails {

    private String paymentMethod;
    private Date paymentDate;
    private int paymentConfirmationNumber;
    private String orderBillingAddressline1;
    private String orderBillingAddressline2;
    private String orderBillingCity;
    private String orderBillingState;
    private int orderBillingZip;

    public PaymentAndBillingDetails() {}

    public PaymentAndBillingDetails(String paymentMethod, Date paymentDate, int paymentConfirmationNumber,
                                    String orderBillingAddressline1, String orderBillingAddressline2,
                                    String orderBillingCity, String orderBillingState, int orderBillingZip) {
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.orderBillingAddressline1 = orderBillingAddressline1;
        this.orderBillingAddressline2 = orderBillingAddressline2;
        this.orderBillingCity = orderBillingCity;
        this.orderBillingState = orderBillingState;
        this.orderBillingZip = orderBillingZip;
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
