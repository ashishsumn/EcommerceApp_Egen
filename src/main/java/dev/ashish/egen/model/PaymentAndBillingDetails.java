package dev.ashish.egen.model;

import java.util.Date;

public class PaymentAndBillingDetails {

    private String orderPaymentMethod;
    private Date orderPaymentDate;
    private int orderPaymentConfirmationNumber;
    private String orderBillingAddressline1;
    private String orderBillingAddressline2;
    private String orderBillingCity;
    private String orderBillingState;
    private int orderBillingZip;

    public PaymentAndBillingDetails() {}

    public PaymentAndBillingDetails(String orderPaymentMethod, Date orderPaymentDate, int orderPaymentConfirmationNumber,
                                    String orderBillingAddressline1, String orderBillingAddressline2,
                                    String orderBillingCity, String orderBillingState, int orderBillingZip) {
        this.orderPaymentMethod = orderPaymentMethod;
        this.orderPaymentDate = orderPaymentDate;
        this.orderPaymentConfirmationNumber = orderPaymentConfirmationNumber;
        this.orderBillingAddressline1 = orderBillingAddressline1;
        this.orderBillingAddressline2 = orderBillingAddressline2;
        this.orderBillingCity = orderBillingCity;
        this.orderBillingState = orderBillingState;
        this.orderBillingZip = orderBillingZip;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public Date getOrderPaymentDate() {
        return orderPaymentDate;
    }

    public void setOrderPaymentDate(Date orderPaymentDate) {
        this.orderPaymentDate = orderPaymentDate;
    }

    public int getOrderPaymentConfirmationNumber() {
        return orderPaymentConfirmationNumber;
    }

    public void setOrderPaymentConfirmationNumber(int orderPaymentConfirmationNumber) {
        this.orderPaymentConfirmationNumber = orderPaymentConfirmationNumber;
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
