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
    @PostMapping(path = "/payment/{meid}/{orderid}/{id}")
    private Payment newPayments(@RequestBody String dataDis, @PathVariable Long meid, @PathVariable Long orderid, @PathVariable Long id)throws JsonParseException, IOException {


        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonNote = actualObj.get("inputNote");
        JsonNode jsonMoney = actualObj.get("inputMoney");

        Payment pa = new Payment();
        pa.setNote(jsonNote.textValue());
        pa.setMoney(jsonMoney.intValue());
        pa.setM(memberRepository.getOne(meid));
        pa.setC(coffeeorderRepository.getOne(orderid));
        pa.setB(staffRepository.getOne(id));
        return paymentRepository.save(pa);


    }

}

