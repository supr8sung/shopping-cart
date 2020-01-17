package com.bench.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Item {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotEmpty
    private Double price;
    @NotEmpty
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ItemType type;

    public Item() {

    }

    public Item(Double price, String name, ItemType type) {

        this.price = price;
        this.name = name;
        this.type = type;
    }

    public Double getPrice() {

        return price;
    }

    public String getName() {

        return name;
    }

    public ItemType getType() {

        return type;
    }
}
