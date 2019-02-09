package com.example.demo.controller;

import com.example.demo.entity.Unit;
import com.example.demo.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UnitController {

    @Autowired private UnitRepository unitRepository;

    @GetMapping(path = "/unit")
    private Collection<Unit> getUnitCollection(){
        return this.unitRepository.findAll().stream().collect(Collectors.toList());
    }
}
