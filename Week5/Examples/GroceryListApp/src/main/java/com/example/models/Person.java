package com.example.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="people")
public class Person {

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="username", unique = true, nullable = false)
    private String username;

    @Column(name="password")
    private String password;

    //Sometimes you will run into cicular printing of returned json, to prevent you can use @JsonIgnore
    @OneToMany(mappedBy="customer", cascade = CascadeType.ALL)
    @JsonIgnore
    List<GroceryList> groceryList;

    public Person(){
        this.groceryList = new ArrayList<>();
    }

    public Person(int id, String firstName, String lastName, String username, String password) {
        this.userId = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.groceryList = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GroceryList> getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(List<GroceryList> groceryList) {
        this.groceryList = groceryList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}