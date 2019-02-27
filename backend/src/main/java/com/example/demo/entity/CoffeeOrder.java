package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import io.micrometer.core.lang.Nullable;

@Entity
@ToString
@EqualsAndHashCode
public class CoffeeOrder{
    @Id
    @SequenceGenerator(name = "coffeeorder_seq",sequenceName = "coffeeorder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "coffeeorder_seq")
    private Long orderid;
    
    @Column(unique = true)
   
    
    private double totalPrice;
    @NotNull
    @Max(value = 99)
    @Min(value = 1)
    private int quantity;


    @ManyToOne(fetch = FetchType.EAGER)
    private CoffeeMenu coffeeMenu;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    private OrderType orderType;

    public CoffeeOrder(){}

    public CoffeeOrder(CoffeeMenu coffeeMenu,Member member,Staff staff,double totalPrice,int quantity,OrderType orderType){
        this.coffeeMenu = coffeeMenu;
        this.member = member;
        this.staff = staff;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.orderType = orderType;

    }

    public void setOrderid(Long orderid) {
        this.orderid = orderid;
    }

    public Long getOrderid() {
        return orderid;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }



    public Staff getStaff() {
        return staff;
    }

    public CoffeeMenu getCoffeeMenu() {
        return coffeeMenu;
    }

    public void setCoffeeMenu(CoffeeMenu coffeeMenu)
    {
        this.coffeeMenu = coffeeMenu;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
