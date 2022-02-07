package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.domain.Wishlist;
import com.bench.shoppingcart.exception.ItemNotFoundException;
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

    public Optional<Wishlist> getItemById(long id) {
        return wishlistRepository.findByItemId(id);
    }

    public void addWishlistItem(Long itemId) throws ItemNotFoundException {
        Optional<Item> item = itemRepository.findById(itemId);
        Optional<Wishlist> wishlist = getItemById(itemId);

        if (item.isPresent()) {
            Item itemChoice = item.get();
            if (!wishlist.isPresent()) {
                Wishlist newWishlist = new Wishlist();
                System.out.println("Wishlist: present not");
                newWishlist.setItemId(itemChoice.getId());
                newWishlist.setName(itemChoice.getName());
                newWishlist.setType(itemChoice.getType());
                wishlistRepository.save(newWishlist);
            } else {
                System.out.println("Wishlist: present to be removed");
                wishlistRepository.delete(wishlist.get());
            }
        }
    }

    public Object getWishlist() {
        return wishlistRepository.findAll();
    }
}
