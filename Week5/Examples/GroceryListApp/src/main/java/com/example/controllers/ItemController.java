package com.example.controllers;

import com.example.models.Item;
import com.example.repository.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;

@RestController()
@RequestMapping("/item")
public class ItemController {

    private ItemService is;

    @Autowired
    public ItemController(ItemService is){
        this.is = is;
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@RequestBody LinkedHashMap<String, String> body){

        String name = body.get("name");
        double price = Double.parseDouble(body.get("price"));

        Item i = is.createItem(name, price);

        return new ResponseEntity<Item>(i, HttpStatus.CREATED);
    }

    @GetMapping("/byName/{name}")
    public Item getByName(@PathVariable("name") String name){
        return is.getItemByName(name);
    }

    @GetMapping("/lessthan")
    public List<Item> getAllLessThan(@RequestParam(name="price") double price){
        return is.getAllItemsLessThanPrice(price);
    }

    @GetMapping("/greaterthan")
    public List<Item> getAllGreaterThan(@RequestParam(name="price") double price){
        return is.getAllItemsGreaterThanPrice(price);
    }

}
