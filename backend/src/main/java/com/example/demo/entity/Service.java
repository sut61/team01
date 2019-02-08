package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Service{

    @Id
    @SequenceGenerator(name = "service_seq",sequenceName = "service_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "service_seq")

    private Long id;
    private String service;


    public Service(){}

    public Service(String service){
        this.service = service;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getService()
    {
        return service;
    }
    
}
