package com.example.models;

import java.util.List;
import java.util.Objects;

public class GroceryList {

    private Person owner;
    private List<GroceryItem> gList;

    public GroceryList(Person owner, List<GroceryItem> gList) {
        this.owner = owner;
        this.gList = gList;
    }

    public GroceryList() {
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public List<GroceryItem> getgList() {
        return gList;
    }

    public void setgList(List<GroceryItem> gList) {
        this.gList = gList;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "owner=" + owner +
                ", gList=" + gList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroceryList that = (GroceryList) o;
        return getOwner().equals(that.getOwner()) && getgList().equals(that.getgList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getgList());
    }
}
