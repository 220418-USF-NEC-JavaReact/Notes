package com.example.dao;

import com.example.models.GroceryItem;

import java.util.ArrayList;
import java.util.List;

public class GroceryDaoMock implements IGroceryDao{

    private List<GroceryItem> itemDB;

    public GroceryDaoMock(){
        itemDB = new ArrayList<>();
    }

    @Override
    public GroceryItem createItem(GroceryItem gi) {
        itemDB.add(gi);
        return gi;
    }

    @Override
    public GroceryItem getItem(GroceryItem gi) {
        int i = itemDB.lastIndexOf(gi);

        if(i == -1){
            return null;
        }else{
            return itemDB.get(i);
        }
    }
}
