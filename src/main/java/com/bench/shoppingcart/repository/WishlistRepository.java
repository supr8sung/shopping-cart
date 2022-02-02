package com.bench.shoppingcart.repository;

import com.bench.shoppingcart.domain.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    @Query(value = "select * from wishlist where item_id = :id", nativeQuery = true)
    Wishlist findItemById(long id);

    @Transactional
    @Modifying
    @Query(value = "update wishlist set price = :price, quantity = :qty where id = :itemId", nativeQuery = true)
    void updateWishList(double price, int qty, Long itemId);
}
