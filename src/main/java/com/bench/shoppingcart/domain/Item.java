package com.bench.shoppingcart.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


@ToString
@Entity
@Data
@Builder(builderClassName = "builder", setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Item implements Comparable<Item> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double price;
    @NotEmpty
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ItemType type;

    public void toString(Long id, Double price, String name, ItemType type) {
        System.out.println("id = " + id);
        System.out.println("price = " + price);
        System.out.println("name = " + name);
        System.out.println("type = " + type.getValue());
    }

    @Override
    public int compareTo(Item item) {
        return Math.toIntExact(this.id = id);
    }
}
