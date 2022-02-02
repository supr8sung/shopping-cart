package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.repository.CartRepository;
import com.bench.shoppingcart.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private WishlistRepository wishlistRepository;

    public Item add(Item item) {
        Item savedItem = cartRepository.save(item);
        savedItem.setName("item_saved");
        return savedItem;
    }

    public Item getItem(long itemId) {
        return cartRepository.findItemById(itemId);
    }

    public Wishlist saveItemToWishlist(Item selectedItem, int quantity) {
        Wishlist savedItems = null;

        if (selectedItem != null) {
            savedItems = wishlistRepository.findItemById(selectedItem.getId());
            if (savedItems != null) {
                int qty = quantity + savedItems.getQuantity();
                double price = qty * selectedItem.getPrice();

                wishlistRepository.updateWishList(price, qty, savedItems.getId());
                return savedItems;
            } else {
                savedItems = new Wishlist();
                if (quantity > 1) {
                    double price = quantity * selectedItem.getPrice();
                    savedItems.setPrice(price);
                } else {
                    savedItems.setPrice(selectedItem.getPrice());
                }
                savedItems.setName(selectedItem.getName());
                savedItems.setQuantity(quantity);
                savedItems.setType(selectedItem.getType());
                savedItems.setItemId(selectedItem.getId());
                wishlistRepository.save(savedItems);
            }
        }
        return savedItems;
    }

    public List<Wishlist> drawWishlist() {
        return wishlistRepository.findAll();
    }
}
