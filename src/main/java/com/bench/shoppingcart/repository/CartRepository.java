package com.bench.shoppingcart.repository;

import com.bench.shoppingcart.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Item, Long> {
    Item findItemById(long itemId);
}
