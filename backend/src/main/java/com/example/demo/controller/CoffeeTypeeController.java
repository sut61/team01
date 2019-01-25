package com.example.demo.controller;
//===================================================PASS==============================================
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.*;
import com.example.demo.repository.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class CoffeeTypeeController {
    @Autowired private CoffeeTypeRepository coffeetypeRepository;

    @GetMapping(path = "/coffeetype")
    private Collection<CoffeeType> getCoffeeTypeCollection(){
        return this.coffeetypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/coffeetype/{id}")
    private CoffeeTypeRepository getCoffeeTypeById(@PathVariable Long id){
        return (CoffeeTypeRepository) this.coffeetypeRepository.findById(id).get();
    }
}