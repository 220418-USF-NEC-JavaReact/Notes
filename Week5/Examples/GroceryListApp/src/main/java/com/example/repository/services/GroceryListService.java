package com.example.repository.services;

import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.models.Person;
import com.example.repository.GroceryListRepo;
import com.example.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GroceryListService {

    private PersonRepo pr;
    private GroceryListRepo gr;

    @Autowired
    public GroceryListService(PersonRepo pr, GroceryListRepo gr){
        this.pr = pr;
        this.gr = gr;
    }

    public GroceryList createList(int userId){
        Person p = pr.getById(userId);

        GroceryList list = new GroceryList(0, p);

        gr.save(list);

        return list;
    }

    public GroceryList addItem(int id, Item i){
        GroceryList list = gr.getById(id);

        List<Item> items = list.getItemList();

        items.add(i);

        list.setItemList(items);
        //Save will update the item if it already exists
        return gr.save(list);
    }

    public GroceryList printList(int id){
        return gr.getById(id);
    }

}


