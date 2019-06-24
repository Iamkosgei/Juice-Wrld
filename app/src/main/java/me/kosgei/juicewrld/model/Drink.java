package me.kosgei.juicewrld.model;


import androidx.annotation.Nullable;

import org.parceler.Parcel;

@Parcel
public class Drink {
    private String name;
    private String price;
    private String url;

    public Drink() {
    }

    public Drink(String name, String price, String url) {
        this.name = name;
        this.price = price;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Drink drink = (Drink) obj;
        return name.equals(drink.name) &&
                price.equals(drink.price)
                && url.equals(drink.url);
    }
}
