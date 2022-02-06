package com.bench.shoppingcart.controller;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {


    @Autowired
    private WishlistService wishlistService;

    public ResponseEntity<Object> add(Wishlist item) {
        Wishlist addedItem = wishlistService.add(item);
        return new ResponseEntity<>(addedItem, HttpStatus.OK);
    }

}
