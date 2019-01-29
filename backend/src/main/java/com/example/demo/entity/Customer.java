package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Customer{

    @Id
    @SequenceGenerator(name = "customer_seq",sequenceName = "customer_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "customer_seq")


    private Long id;
    private String customerName;


    public Customer(){}

    public Customer(String customerName){
        this.customerName = customerName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
}
