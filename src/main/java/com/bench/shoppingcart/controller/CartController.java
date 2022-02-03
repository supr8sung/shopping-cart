package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.service.CartService;
import com.bench.shoppingcart.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private WishlistService wishlistService;

    @PostMapping
    public ResponseEntity<Item> add(@RequestBody Item item) {
        Item savedItem = cartService.add(item);
        return new ResponseEntity<>(savedItem, CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Item>> getAll() {
        List<Item> items = cartService.getAll();
        return new ResponseEntity<>(items, OK);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        cartService.deleteById(id);
    }

    @PostMapping("/wishlist/{itemId}")
    public ResponseEntity<Wishlist> addToWishlist(@PathVariable long itemId)
    {
        wishlistService.addWishlistItem(itemId);
        return new ResponseEntity<>(CREATED);
    }
}
