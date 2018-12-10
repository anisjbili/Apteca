package com.example.asus.an_teca;

/**
 * Created by ASUS on 23/11/2017.
 */

public class ProductInfo {
    String name;
    String price;
    String id;

    public ProductInfo(String name, String price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public ProductInfo(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPrice() {
        return price;
    }
}
