package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping
    public ResponseEntity<Item> add(@RequestBody Item item) {
        Item savedItem = cartService.add(item);

        return new ResponseEntity<>(savedItem, CREATED);

    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll(){
        List<Item> items = cartService.getAll();
        return new ResponseEntity<>(items, OK);
    }

    @DeleteMapping
    public void delete(@PathVariable Long id){
        cartService.deleteById(id);
    }
}
