package me.kosgei.juicewrld.model;

public class Cart {
    private Drink drink;
    private int quantity;
    private int totalPrice;

    public Cart() {
    }

    public Cart(Drink drink, int quantity, int totalPrice) {
        this.drink = drink;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
