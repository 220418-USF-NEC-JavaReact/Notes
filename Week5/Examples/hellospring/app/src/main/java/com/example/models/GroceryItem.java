package com.example.models;

import java.util.Objects;

public class GroceryItem {

    private String name;
    private double price;

    public GroceryItem(){}

    public GroceryItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroceryItem that = (GroceryItem) o;
        return Double.compare(that.getPrice(), getPrice()) == 0 && getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }
}
