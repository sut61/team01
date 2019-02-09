package com.example.demo.controller;

import com.example.demo.entity.Credittype;
import com.example.demo.repository.CredittypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CredittypeController {

    @Autowired private CredittypeRepository credittypeRepository;

    @GetMapping(path = "/credittype")
    private Collection<Credittype> getCredittypeCollection(){
        return this.credittypeRepository.findAll().stream().collect(Collectors.toList());
    }
}
