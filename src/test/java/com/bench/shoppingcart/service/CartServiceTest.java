package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.repository.CartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceTest {

    @InjectMocks
    private CartService cartService;

    @Mock
    private CartRepository cartRepository;


    @Test
    void should_be_able_to_add_an_item() {

        Item item = Item.builder().withName("item1").withPrice(4500d).build();
        Item savedItem = Item.builder().withId(1).withName("item2").withPrice(4500d).build();
        when(cartRepository.save(any())).thenReturn(savedItem);
        Item response = cartService.add(item);
        Assertions.assertEquals("item_saved", response.getName());
    }
}