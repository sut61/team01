package com.example.demo.controller;

import com.example.demo.entity.Amount;
import com.example.demo.repository.AmountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AmountController {

    @Autowired private AmountRepository amountRepository;

    @GetMapping(path = "/amount")
    private Collection<Amount> getAmountCollection(){
        return this.amountRepository.findAll().stream().collect(Collectors.toList());
    }
}
