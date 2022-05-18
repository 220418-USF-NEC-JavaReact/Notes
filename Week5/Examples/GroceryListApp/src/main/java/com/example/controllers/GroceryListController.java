package com.example.controllers;

import com.example.models.GroceryList;
import com.example.models.Item;
import com.example.repository.services.GroceryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/list")
public class GroceryListController {

    private GroceryListService gs;

    @Autowired
    public GroceryListController(GroceryListService gs){
        this.gs = gs;
    }

    @PostMapping("/create")
    public GroceryList createList(@RequestParam(name="userId")int id){
        return gs.createList(id);
    }

    @GetMapping("/byId/{id}")
    public GroceryList getById(@PathVariable("id")int id){
        return gs.printList(id);
    }

    @PutMapping("/addItem/{id}")
    public GroceryList addItem(@RequestBody Item i, @PathVariable("id") int id){
        return gs.addItem(id, i);
    }

}
