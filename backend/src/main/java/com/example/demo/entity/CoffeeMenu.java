package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class CoffeeMenu{
    @Id
    @SequenceGenerator(name = "coffeemenu_seq",sequenceName = "coffeemenu_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "coffeemenu_seq")

    private Long id;
    private String itemName;

    public CoffeeMenu(){}

    public CoffeeMenu(String itemName){
        this.itemName = itemName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
