package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Delivery implements Serializable {

    @Id
    private Integer deliveryCode;
    private String description;
    private int shippingCharges;

    public Delivery() {}

    public Delivery(Integer deliveryCode, String description, int shippingCharges) {
        this.deliveryCode = deliveryCode;
        this.description = description;
        this.shippingCharges = shippingCharges;
    }

    public Integer getDeliveryCode() {
        return deliveryCode;
    }

    public void setDeliveryCode(Integer deliveryCode) {
        this.deliveryCode = deliveryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(int shippingCharges) {
        this.shippingCharges = shippingCharges;
    }
}
