package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Price {

    @Id
    @SequenceGenerator(name = "price_seq",sequenceName = "price_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "price_seq")

    private Long id;
    private String price;


    public Price(){}

    public Price(String price){
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice()
    {
        return price;
    }
    
}
