package com.example.repository.services;

import com.example.models.Item;
import com.example.repository.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private ItemRepo ir;

    @Autowired
    public ItemService(ItemRepo ir){
        this.ir = ir;
    }

    public Item createItem(String name, double price){
        Item i = new Item(0, name, price);
        return ir.save(i);
    }

    public Item getItemByName(String name){
        return ir.findByName(name);
    }

    public List<Item> getAllItems(){
        return ir.findAll();
    }

    public List<Item> getAllItemsGreaterThanPrice(double price){
        return ir.findByPriceGreaterThan(price);
    }

    public List<Item> getAllItemsLessThanPrice(double price){
        return ir.findByPriceLessThan(price);
    }

}
