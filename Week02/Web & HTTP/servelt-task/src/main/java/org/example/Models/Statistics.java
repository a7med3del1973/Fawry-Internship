package org.example.Models;

public class Statistics {
    private double totalPrice;
    private int numberOfProducts;
    public Statistics(double totalPrice, int numberOfProducts) {
        this.totalPrice = totalPrice;
        this.numberOfProducts = numberOfProducts;
    }
    public double getTotalPrice() {
        return totalPrice;
    }
    public int getNumberOfProducts() {
        return numberOfProducts;
    }
}
