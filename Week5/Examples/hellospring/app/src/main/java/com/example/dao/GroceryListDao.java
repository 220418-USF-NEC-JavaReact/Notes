package com.example.dao;

import com.example.models.GroceryItem;
import com.example.models.GroceryList;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

public class GroceryListDao implements IGroceryListDao{

    private List<GroceryList> listDB;

    public GroceryListDao(){
        this.listDB = new ArrayList<>();
    }


    @Override
    public GroceryList createList(GroceryList gl) {
        listDB.add(gl);
        return gl;
    }

    @Override
    public GroceryList getGroceryList(GroceryList gl) {
        int i = listDB.lastIndexOf(gl);

        if(i == -1){
            return null;
        }else{
            return listDB.get(i);
        }
    }
}
