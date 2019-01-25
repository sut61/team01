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
    @GetMapping(path = "/payment/{payid}")
    private PaymentRepository getPaymentById(@PathVariable Long payid){
        return (PaymentRepository) this.paymentRepository.findById(payid).get();
    }
    @PostMapping(path = "/payment/{memid}/{orderid}/{staffid}")
    private Payment newPayments(@RequestBody String dataDis, @PathVariable Long memid, @PathVariable Long orderid, @PathVariable Long staffid)throws JsonParseException, IOException {


        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonNote = actualObj.get("inputNote");

        Payment pa = new Payment();
        pa.setNote(jsonNote.textValue());
        pa.setM(memberRepository.getOne(memid));
        pa.setC(coffeeorderRepository.getOne(orderid));
        pa.setB(staffRepository.getOne(staffid));
        return paymentRepository.save(pa);


    }

}

