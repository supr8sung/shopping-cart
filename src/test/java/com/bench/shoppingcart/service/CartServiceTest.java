package com.bench.shoppingcart.service;

import com.bench.shoppingcart.domain.Item;
import com.bench.shoppingcart.repository.CartRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void should_be_able_to_delete_an_item() {
        Item item = Item.builder().withId(1).withName("item_test").withPrice(300d).build();
        cartService.deleteById(item.getId());
    }

    @Test
    void should_be_able_to_fetch_all_items(){
//        List<Item> items = Arrays.asList(Item.builder().withId(1).withName("item_test").withPrice(300d).build(),
//                Item.builder().withId(2).withName("item_test").withPrice(300d).build());
        Item item1 = Item.builder().withId(1).withName("item_test").withPrice(300d).build();
        Item item2 = Item.builder().withId(2).withName("item_test").withPrice(300d).build();
        List<Item> items = new ArrayList<>();
        items.add(item1);
        items.add(item2);
        when(cartRepository.findAll()).thenReturn(items);
        ArrayList<Item> itemsResponse = (ArrayList<Item>) cartService.getAll();
        Assertions.assertEquals(2,itemsResponse.size());
    }
}