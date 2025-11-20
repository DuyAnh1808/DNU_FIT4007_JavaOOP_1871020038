package models;

import java.io.Serializable;
import java.util.Date;

public abstract class Order implements Serializable {
    protected String orderId;
    protected String productId;
    protected int quantity;
    protected Date date;

    public Order(String orderId, String productId, int quantity, Date date) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.date = date;
    }

    public abstract void process();
}