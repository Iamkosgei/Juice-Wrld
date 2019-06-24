package me.kosgei.juicewrld.model;

import java.util.Date;
import java.util.List;

public class Order {
    private List<Cart> carts;
    private String status;
    private Date date;

    public Order() {
    }

    public Order(List<Cart> carts, String status, Date date) {
        this.carts = carts;
        this.status = status;
        this.date = date;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
