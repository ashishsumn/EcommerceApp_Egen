package dev.ashish.egen.model;

import java.util.Date;
import java.util.List;

public class OrderDetails {

    private String orderStatus;
    private String orderCustomerId;
    private Date createdDate;
    private Date modifiedDate;
    private String orderShippingAddressline1;
    private String orderShippingAddressline2;
    private String orderShippingCity;
    private String orderShippingState;
    private int orderShippingZip;
    private int deliveryCode;
    private List<OrderItems> orderItemList;
    private List<PaymentAndBillingDetails> paymentAndBillingDetailsList;

    public OrderDetails() {}

    public OrderDetails(String orderStatus, String orderCustomerId, Date createdDate, Date modifiedDate,
                        double orderSubtotal, String orderShippingAddressline1, String orderShippingAddressline2,
                        String orderShippingCity, String orderShippingState, int orderShippingZip, int deliveryCode,
                        List<OrderItems> orderItemList, List<PaymentAndBillingDetails> paymentAndBillingDetailsList) {
        this.orderStatus = orderStatus;
        this.orderCustomerId = orderCustomerId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.orderShippingAddressline1 = orderShippingAddressline1;
        this.orderShippingAddressline2 = orderShippingAddressline2;
        this.orderShippingCity = orderShippingCity;
        this.orderShippingState = orderShippingState;
        this.orderShippingZip = orderShippingZip;
        this.deliveryCode = deliveryCode;
        this.orderItemList = orderItemList;
        this.paymentAndBillingDetailsList = paymentAndBillingDetailsList;
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

    public List<OrderItems> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItems> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public List<PaymentAndBillingDetails> getPaymentAndBillingDetailsList() {
        return paymentAndBillingDetailsList;
    }

    public void setPaymentAndBillingDetailsList(List<PaymentAndBillingDetails> paymentAndBillingDetailsList) {
        this.paymentAndBillingDetailsList = paymentAndBillingDetailsList;
    }
}
