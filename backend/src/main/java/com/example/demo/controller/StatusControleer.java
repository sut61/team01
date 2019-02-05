package com.example.demo.controller;

import com.example.demo.entity.Status;
import com.example.demo.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatusControleer {
    @Autowired
    private StatusRepository statusRepository;

    public StatusControleer(StatusRepository statusRepository){
        this.statusRepository = statusRepository;
    }

    @GetMapping("/Status")
    public Collection<Status> Status(){
        return statusRepository.findAll().stream().collect(Collectors.toList());
    }
}
