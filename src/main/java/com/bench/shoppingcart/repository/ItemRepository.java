package com.bench.shoppingcart.repository;

import com.bench.shoppingcart.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ItemRepository extends JpaRepository<Item,Long> {
}
