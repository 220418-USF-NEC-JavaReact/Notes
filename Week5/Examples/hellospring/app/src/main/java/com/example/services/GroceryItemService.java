package com.example.services;

import com.example.dao.GroceryDaoMock;
import com.example.dao.IGroceryDao;
import com.example.models.GroceryItem;

public class GroceryItemService {

    private IGroceryDao gDao;

    public GroceryItemService(){

    }

    public GroceryItem addItem(String name, double price){
        GroceryItem gi = new GroceryItem(name, price);
        return gDao.createItem(gi);
    }

    public void setgDao(IGroceryDao gDao){
        this.gDao = gDao;
    }

}
