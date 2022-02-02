package com.bench.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@Builder(builderClassName = "builder", setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double price;
    @NotEmpty
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ItemType type;
    private int quantity;
    private Long itemId;
}

