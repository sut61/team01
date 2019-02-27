package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Allcontroller{
    @Autowired private CoffeeMenuRepository coffeeMenuRepository;
    @Autowired private CoffeeOrderRepository coffeeOrderRepository;
    @Autowired private CustomerRepository customerRepository;
    @Autowired private StaffRepository staffRepository;
    @Autowired private OrderTypeRepository orderTypeRepository;
    @Autowired private MemberRepository memberRepository;



    @GetMapping(path = "/coffeemenu")
    private Collection<CoffeeMenu> getCoffeeMenu(){
        return this.coffeeMenuRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/coffeeorder")
    private Collection<CoffeeOrder> getCoffeeorder(){
        return this.coffeeOrderRepository.findAll().stream().collect(Collectors.toList());
    }

 

    @GetMapping(path = "/staff")
    private Collection<Staff> getStaff(){
        return this.staffRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/staff/{username}/{password}")
    public boolean customer1(@PathVariable String username, @PathVariable String password) {
        Staff user = staffRepository.findByUsername(username);
        String p = user.getPassword();
        System.out.println(username);
        System.out.println(p + " = " + password);
        return p.matches(password);
    }
    @GetMapping(path = "/ordetytpe")
    private Collection<OrderType> getOrdertype(){
        return this.orderTypeRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping(path = "/coffeeorder/{staffName}/{nameM}/{itemName}/{quantity}/{totalPrice}/{orderType}")
    public CoffeeOrder coffeeOrder(@PathVariable Long staffName, @PathVariable Long nameM, @PathVariable Long itemName, @PathVariable int quantity, @PathVariable double totalPrice, @PathVariable Long orderType){


        CoffeeOrder coffeeOrder = new CoffeeOrder();
        coffeeOrder.setTotalPrice(totalPrice);
        coffeeOrder.setQuantity(quantity);

        CoffeeMenu coffeeMenu1 = coffeeMenuRepository.findById(itemName).get();
        coffeeOrder.setCoffeeMenu(coffeeMenu1);

        Member memberxy1 = memberRepository.findById(nameM).get();
        coffeeOrder.setMember(memberxy1);

        Staff staff1 = staffRepository.findById(staffName).get();
        coffeeOrder.setStaff(staff1);

        OrderType orderType1 = orderTypeRepository.findById(orderType).get();
        coffeeOrder.setOrderType(orderType1);

        coffeeOrderRepository.save(coffeeOrder);
        return coffeeOrder;


    }

}
