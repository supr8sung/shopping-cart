package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public Item add(Item item) {
        Item savedItem = cartRepository.save(item);
        savedItem.setName("item_saved");
        return savedItem;
    }

    public List<Item> getAll(){
        List<Item> items = cartRepository.findAll();
        return items;
    }

    public void deleteById(Long id){
        cartRepository.deleteById(id);
    }
}
