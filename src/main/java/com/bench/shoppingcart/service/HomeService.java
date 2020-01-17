package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems() {
            return itemRepository.findAll();
    }

    public void addItem(Item item) {
        itemRepository.save(item);
        System.out.println("Item saved successfully");

    }
}
