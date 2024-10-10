package org.example.Models;

public class Product {
    private int id;
    private String name;
    private double price;
    private String ownerEmail;
    public Product(int id, String name, double price, String ownerEmail) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.ownerEmail = ownerEmail;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price > 0? price : 0;
    }
    public String getOwnerEmail() {
        return ownerEmail;
    }
    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }
}
