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
class ManuTypeController {
    @Autowired
    private ManuTypeRepository manutypeRepository;

    @GetMapping(path = "/manutype")
    private Collection<ManuType> getManuTypeCollection() {
        return this.manutypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/manutype/{id}")
    private ManuTypeRepository getManuTypeById(@PathVariable Long id) {
        return (ManuTypeRepository) this.manutypeRepository.findById(id).get();
    }
}