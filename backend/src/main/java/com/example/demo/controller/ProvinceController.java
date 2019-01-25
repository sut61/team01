package com.example.demo.controller;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {

    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private NametypeRepository nametypeRepository;
    @Autowired
    private GenderRepository genderRepository;
    @Autowired
    private final ProvinceRepository provinceRepository;

    ProvinceController(ProvinceRepository provinceRepository) {
        this.provinceRepository = provinceRepository;
    }

    @GetMapping(path = "/province")
    private Collection<Province> Records(){
        return this.provinceRepository.findAll().stream().collect(Collectors.toList());
    }
    @PostMapping(path = "/province")
    private Province newProvince(@RequestBody Province newProvince, @PathVariable Long pid, @PathVariable String disease, @PathVariable String namepa, @PathVariable String program, @PathVariable Integer payment) {

        Province newProvinces = new Province();

        newProvinces.setNamePa(namepa);
        newProvinces.setPid(pid);

            return provinceRepository.save(newProvinces);
        }
}


