package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.http.HttpStatus.CREATED;
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

}
