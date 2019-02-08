package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Vibe{

    @Id
    @SequenceGenerator(name = "vibe_seq",sequenceName = "vibe_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "vibe_seq")

    private Long id;
    private String vibe;


    public Vibe(){}

    public Vibe(String vibe){
        this.vibe = vibe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public String getVibe()
    {
        return vibe;
    }
    
}
