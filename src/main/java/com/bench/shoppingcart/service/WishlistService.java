package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.repository.ItemRepository;
import com.bench.shoppingcart.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WishlistService {

    @Autowired
    WishlistRepository wishlistRepository;

    @Autowired
    ItemRepository itemRepository;

    public Optional<Wishlist> getItemById(long id)
    {
        return wishlistRepository.findById(id);
    }

    public void addWishlistItem(Long itemId) {
        Optional<Item> item = itemRepository.findById(itemId);
        Wishlist wishlist = new Wishlist();
        if (item.isPresent()) {
            Item itemChoice = item.get();

            if (!getItemById(itemId).isPresent()) {
                wishlist.setItemId(itemChoice.getId());
                wishlist.setName(itemChoice.getName());
                wishlist.setType(itemChoice.getType());
                wishlistRepository.save(wishlist);
            }
        }
    }
}
