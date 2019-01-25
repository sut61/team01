package com.example.demo.controller;

import com.example.demo.entity.ServiceType;
import com.example.demo.repository.ServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ServiceTypeController {

    @Autowired
        private final ServiceTypeRepository serviceTypeRepository;


    public ServiceTypeController(ServiceTypeRepository serviceTypeRepository) {
        this.serviceTypeRepository = serviceTypeRepository;
    }

    @GetMapping("/ServiceType")
    public Collection<ServiceType> OrderType(){
        return serviceTypeRepository.findAll().stream().collect(Collectors.toList());

    }


}
