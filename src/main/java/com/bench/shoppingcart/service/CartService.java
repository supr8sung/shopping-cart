package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.exception.ItemNotFoundException;
import com.bench.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return cartRepository.findAll();
    }

    public void deleteById(Long id){
        Optional<Item> item = cartRepository.findById(id);
        if(item.isPresent()){
            cartRepository.deleteById(id);
        }
        throw new ItemNotFoundException();
    }
}