package com.example.demo.controller;
//===================================================PASS==============================================
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
class ManuController {

//    private ManuRepository repository;
//
//    public ManuController(ManuRepository manuRepository, CoffeeTypeRepository coffeetypeRepository,
//                          BakeryTypeRepository bakerytypeRepository,
//                          ManuTypeRepository manutypeRepository) {
//        this.repository = repository;
//    }

    @Autowired
    private ManuRepository manuRepository;
    @Autowired
    private ManuTypeRepository manutypeRepository;
    @Autowired
    private CoffeeTypeRepository coffeetypeRepository;
    @Autowired
    private BakeryTypeRepository bakerytypeRepository;

    @GetMapping("/manu")
    public Collection<Manu> manu() {
        return manuRepository.findAll().stream()
                .filter(this::isManu)
                .collect(Collectors.toList());
    }

    private boolean isManu(Manu manu) {
        return !manu.getName().equals("no no!");
    }
    @GetMapping(path = "/Manu")
    public Collection<Manu> manuRepository() {
        return manuRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Manu/{id}")
    private ManuRepository getManuById(@PathVariable Long id){
        return (ManuRepository) this.manuRepository.findById(id).get();
    }



    @PostMapping(path = "/manu/{manutypeid}/{coffeeid}/{bakeryid}")
    private Manu newManus(@RequestBody String dataDis,@PathVariable Long manutypeid, @PathVariable Long coffeeid,
                     @PathVariable Long bakeryid) throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(dataDis, "UTF-8");
        dataDis = decoded;
        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataDis);
        JsonNode jsonName = actualObj.get("inputName");
        JsonNode jsonPrice = actualObj.get("inputPrice");

        Manu manu = new Manu();
        manu.setName(jsonName.textValue());
        manu.setPrice(jsonPrice.doubleValue());
        manu.setManutype(manutypeRepository.getOne(manutypeid));
        manu.setBakerytype(bakerytypeRepository.getOne(bakeryid));
        manu.setCoffeetype(coffeetypeRepository.getOne(coffeeid));
        return manuRepository.save(manu);

    }

}
