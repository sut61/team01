package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TypeDeleteController {

    
    @Autowired
    private final TypeDeleteRepository typeDeleteRepository;

    TypeDeleteController(TypeDeleteRepository typeDeleteRepository) {
        this.typeDeleteRepository = typeDeleteRepository;
    }

    @GetMapping(path = "/typedelete")
    private Collection<TypeDelete> Records(){
        return this.typeDeleteRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/typedelete")
    private TypeDelete newtypeDelete(@RequestBody TypeDelete newttypeDelete, @PathVariable Long typedeleteid, @PathVariable String typeD) {

        TypeDelete newtypedelete = new TypeDelete();

        newttypeDelete.setTyptD(typeD);
        newttypeDelete.setTypedeleteid(typedeleteid);

            return typeDeleteRepository.save(newttypeDelete);
        }
}


