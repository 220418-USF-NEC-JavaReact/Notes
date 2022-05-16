package com.example.dao;

import com.example.models.GroceryList;

public interface IGroceryListDao {

    public GroceryList createList(GroceryList gl);

    public GroceryList getGroceryList(GroceryList gl);

}
