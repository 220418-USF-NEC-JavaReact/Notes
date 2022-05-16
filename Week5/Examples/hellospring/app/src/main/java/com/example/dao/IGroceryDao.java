package com.example.dao;

import com.example.models.GroceryItem;

public interface IGroceryDao {

    public GroceryItem createItem(GroceryItem gi);

    public GroceryItem getItem(GroceryItem gi);

}
