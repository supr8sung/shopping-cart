package com.bench.shoppingcart.domain;

import java.util.Comparator;

public class PriceCompare implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getPrice() > o2.getPrice()) {
            return 1;
        } else if (o1.getPrice() < o2.getPrice()) {
            return -1;
        } else return 0;
    }
}
