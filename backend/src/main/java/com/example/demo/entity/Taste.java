package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Taste{

    @Id
    @SequenceGenerator(name = "taste_seq",sequenceName = "taste_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "taste_seq")

    private Long id;
    private String taste;


    public Taste(){}

    public Taste(String taste){
        this.taste = taste;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTaste()
    {
        return taste;
    }
    
}
