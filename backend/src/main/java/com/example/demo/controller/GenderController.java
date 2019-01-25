package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GenderController {
    @Autowired private GenderRepository genderRepository;

    @Autowired
    GenderController(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @GetMapping(path = "/gender")
    private Collection<Gender> getPatientCollection() {
        return this.genderRepository.findAll().stream().collect(Collectors.toList());
    }

    @PutMapping(path = "/gender/{PaId}")
    private Gender replaceGender(@RequestBody Gender newGender, @PathVariable Long gid) {
        return genderRepository.findById(gid).map(gender -> {

            gender.setGender(newGender.getGender());
            return genderRepository.save(gender);
        }).orElseGet(() -> {
            newGender.setGid(gid);
            return genderRepository.save(newGender);
        });
    }
    @PostMapping(path = "/gender")
    private Gender newgender(@RequestBody Gender newGender){
        return genderRepository.save(newGender);
    }
}
