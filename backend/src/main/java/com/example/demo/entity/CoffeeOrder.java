package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class CoffeeOrder{
    @Id
    @SequenceGenerator(name = "coffeeorder_seq",sequenceName = "coffeeorder_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "coffeeorder_seq")

    private Long orderid;
    private String totalPrice;
    private String quantity;


    @ManyToOne(fetch = FetchType.EAGER)
    private CoffeeMenu coffeeMenu;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

    @ManyToOne(fetch = FetchType.EAGER)
    private OrderType orderType;

    public CoffeeOrder(){}

    public CoffeeOrder(CoffeeMenu coffeeMenu,Member member,Staff staff,String totalPrice,String quantity,OrderType orderType){
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

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

    public Staff getStaff() {
        return staff;
    }

//    public Customer getCustomer() {
//        return customer;
//    }

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
