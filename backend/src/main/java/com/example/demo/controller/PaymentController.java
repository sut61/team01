package com.example.demo.controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.io.IOException;
import java.net.URLDecoder;
import  java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

    @Autowired
    StaffRepository staffRepository;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    CoffeeOrderRepository coffeeorderRepository;
    @Autowired
    PaymentRepository paymentRepository;

    @Autowired PaymentController(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }


    @GetMapping(path = "/payment")
    private Collection<Payment> getPaymentCollection(){
        return this.paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path = "/payment/{nameM}/{orderid}/{staffName}/{discount}/{cash}/{change}/{date}/{note}")
    public Payment payment (@PathVariable Long staffName, @PathVariable Long nameM, @PathVariable Long orderid, @PathVariable Double discount, @PathVariable Double cash, @PathVariable Double change, @PathVariable Date date, @PathVariable String note){

        Payment payment = new Payment();
        payment.setDiscount(discount);
        payment.setCash(cash);
        payment.setChange(change);
        payment.setDate(date);
        payment.setNote(note);

        Staff staff1 = staffRepository.findById(staffName).get();
        payment.setStaff(staff1);

        Member member1 = memberRepository.findById(nameM).get();
        payment.setMember(member1);

        CoffeeOrder coffeeOrder1 = coffeeorderRepository.findById(orderid).get();
        payment.setCoffeeorder(coffeeOrder1);

        paymentRepository.save(payment);
        return payment;
    }

}

