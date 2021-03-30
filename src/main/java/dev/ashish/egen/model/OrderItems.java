package dev.ashish.egen.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class OrderItems implements Serializable {

    @EmbeddedId
    private OrderProductId orderProductId;
    private int order_item_qty;

    public OrderItems() {}

    public OrderItems(int order_item_qty){
        this.order_item_qty = order_item_qty;
    }

    public int getOrder_item_qty() {
        return order_item_qty;
    }

    public void setOrder_item_qty(int order_item_qty) {
        this.order_item_qty = order_item_qty;
    }
}