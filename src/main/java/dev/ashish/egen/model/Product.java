package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private int product_id;
    private String product_name;
    private int product_inventory;

    public Product() {}

    public Product(String product_name, int product_inventory){
        this.product_name = product_name;
        this.product_inventory = product_inventory;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getProduct_inventory() {
        return product_inventory;
    }

    public void setProduct_inventory(int product_inventory) {
        this.product_inventory = product_inventory;
    }
}
