package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/addToWishlist/{itemId}/{quantity}")
    public ResponseEntity<Wishlist> wishlistItems(@PathVariable long itemId, @PathVariable int quantity) {
        Item selectedItem = cartService.getItem(itemId);

        if (selectedItem != null) {
            Wishlist wishlist = cartService.saveItemToWishlist(selectedItem, quantity);
            return new ResponseEntity<Wishlist>(wishlist, CREATED);
        } else
            return new ResponseEntity<Wishlist>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/wishlist")
    public List<Wishlist> getWishList() {
        return cartService.drawWishlist();
    }

}
