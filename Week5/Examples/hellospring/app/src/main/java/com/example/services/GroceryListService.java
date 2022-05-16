package com.example.services;

import com.example.dao.GroceryListDao;
import com.example.dao.IGroceryListDao;
import com.example.models.GroceryItem;
import com.example.models.GroceryList;
import com.example.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class GroceryListService {


    private IGroceryListDao glDao;

    @Autowired
    public GroceryListService(IGroceryListDao glDao){
        this.glDao = glDao;
    }

    public GroceryList createGroceryList(Person owner, List<GroceryItem> gList){
        GroceryList gl = new GroceryList(owner, gList);
        return glDao.createList(gl);
    }
}
