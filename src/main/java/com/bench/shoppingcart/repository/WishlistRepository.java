package com.bench.shoppingcart.repository;

import com.bench.shoppingcart.domain.Wishlist;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends CrudRepository<Wishlist, Long> {
}
