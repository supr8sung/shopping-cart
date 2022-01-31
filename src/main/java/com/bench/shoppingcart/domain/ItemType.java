package com.bench.shoppingcart.domain;

public enum ItemType {
    SHOES("Shoes"), DRESSES("Dress"), SPORTS("Sports");

    private String value;

    public String getValue() {

        return value;
    }

    ItemType(String value) {

        this.value = value;
    }
}
