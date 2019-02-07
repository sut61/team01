package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Typereward{

    @Id
    @SequenceGenerator(name = "typerewards_seq",sequenceName = "typerewards_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "typerewards_seq")

    private Long id;

    private @NonNull String typeRe;


    public Typereward(){}

    public Typereward(String typeRe){this.typeRe = typeRe;}

    public void setId(Long id){this.id = id;}  public Long getId(){return id;}

    public void setTypere(String typeRe){this.typeRe = typeRe;} public String getTypere(){return typeRe;}


}