package dev.ashish.egen.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Delivery implements Serializable {

    @Id
    private Integer delivery_code;
    private String description;
    private int shipping_charges;

    public Delivery() {}

    public Delivery(String description, int shipping_charges){
        this.description = description;
        this.shipping_charges = shipping_charges;
    }

    public int getDelivery_code() {
        return delivery_code;
    }

    public void setDelivery_code(int delivery_code) {
        this.delivery_code = delivery_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getShipping_charges() {
        return shipping_charges;
    }

    public void setShipping_charges(int shipping_charges) {
        this.shipping_charges = shipping_charges;
    }
}
