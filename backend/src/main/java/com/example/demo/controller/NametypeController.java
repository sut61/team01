package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NametypeController {

    @Autowired
    private NametypeRepository nametypeRepository;

    @Autowired
    NametypeController(NametypeRepository nametypeRepository) {
        this.nametypeRepository = nametypeRepository;
    }

    @GetMapping(path = "/nametype")
    private Collection<Nametype> getNametypeCollection(){
        return this.nametypeRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/nametype/{id}")
    private Nametype replaceNametype(@RequestBody Nametype newNametype, @PathVariable Long nid) {
        return nametypeRepository.findById(nid).map(nametype -> {
            nametype.setNameDoc(newNametype.getNameDoc());
            return nametypeRepository.save(nametype);
        }).orElseGet(() -> {
            newNametype.setNid(nid);
            return nametypeRepository.save(newNametype);
        });
    }
    @PostMapping(path = "/nametype")
   private Nametype newDoctor(@RequestBody Nametype newNametype){
       return nametypeRepository.save(newNametype);
    }
}

