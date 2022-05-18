package com.example.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="grocerylist")
public class GroceryList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="grocerylist_id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person customer;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="list_item_junction",
            joinColumns = {@JoinColumn(name="list_id")},
            inverseJoinColumns = {@JoinColumn(name="item_id")}
    )
    List<Item> itemList;

    public GroceryList(){
        this.itemList = new ArrayList<>();
    }

    public GroceryList(int id, Person customer) {
        this.id = id;
        this.customer = customer;
        this.itemList = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person getCustomer() {
        return customer;
    }

    public void setCustomer(Person customer) {
        this.customer = customer;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public String toString() {
        return "GroceryList{" +
                "id=" + id +
                ", customer=" + customer +
                ", itemList=" + itemList +
                '}';
    }
}
