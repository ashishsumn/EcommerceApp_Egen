package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderItems implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long order_item_id;
    private Long order_id;
    private String order_item_name;
    private int order_item_qty;

    public OrderItems() {}

    public OrderItems(Long order_id, String order_item_name, int order_item_qty){
        this.order_id = order_id;
        this.order_item_name = order_item_name;
        this.order_item_qty = order_item_qty;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public String getOrder_item_name() {
        return order_item_name;
    }

    public void setOrder_item_name(String order_item_name) {
        this.order_item_name = order_item_name;
    }

    public int getOrder_item_qty() {
        return order_item_qty;
    }

    public void setOrder_item_qty(int order_item_qty) {
        this.order_item_qty = order_item_qty;
    }
}
