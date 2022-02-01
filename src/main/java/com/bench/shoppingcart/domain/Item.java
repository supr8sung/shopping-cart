package com.bench.shoppingcart.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.deser.SettableBeanProperty;
import lombok.*;

@Entity
@Data
@Builder(builderClassName = "builder", setterPrefix = "with")
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Double price;
    @NotEmpty
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ItemType type;

}
