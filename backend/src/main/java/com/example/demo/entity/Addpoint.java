package com.example.demo.entity;
import lombok.*;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Addpoint {
    @Id
    @SequenceGenerator(name = "addpoint_seq",sequenceName = "addpoint_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "addpoint_seq")
    private Long id;
    private String addPoint;

    public Addpoint(){}

    public Addpoint(String addPoint){
        this.addPoint = addPoint;
    }

    public void setID(Long id){this.id = id;} public Long getId(){return id;}

    public void setAddPoint(String addPoint){this.addPoint = addPoint;} public String getAddPoint(){return addPoint;}
}
