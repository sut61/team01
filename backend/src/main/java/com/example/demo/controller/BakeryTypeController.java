package com.example.demo.controller;
//===================================================PASS==============================================
import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
class BakeryTypeController {

    @Autowired private BakeryTypeRepository bakerytypeRepository;

    @GetMapping(path = "/bakerytype")
    private Collection<BakeryType> getBakerytpeCollection() {
        return this.bakerytypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/bakerytype/{id}")
    private BakeryTypeRepository getBakeryTypeById(@PathVariable Long id){
        return (BakeryTypeRepository) this.bakerytypeRepository.findById(id).get();
    }
}
