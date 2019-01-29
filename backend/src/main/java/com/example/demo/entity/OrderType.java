package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class OrderType{
    @Id
    @SequenceGenerator(name = "ordertype_sreq",sequenceName = "ordertype_sreq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ordertype_sreq")

    private Long id;
    private String orderTypes;

    public OrderType(){}

    public OrderType(String orderTypes){
        this.orderTypes = orderTypes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getOrderTypes() {
        return orderTypes;
    }

    public void setOrderTypes(String orderTypes) {
        this.orderTypes = orderTypes;
    }
}
