package com.example.repository;

import com.example.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepo extends JpaRepository<Item, Integer> {

    Item findByName(String name);

    List<Item> findByPriceLessThan(double price);

    List<Item> findByPriceGreaterThan(double price);

}
