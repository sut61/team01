package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@ToString
@EqualsAndHashCode
public class Staff{

    @Id
    @SequenceGenerator(name = "staff_seq",sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_seq")

    private Long id;

    
    private String staffName;
    @Size(max = 50,min = 2) 
    private String username;
    private String password;

    public Staff(){}

    public Staff(String staffName){
        this.staffName = staffName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffName()
    {
        return staffName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername()
    {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword()
    {
        return password;
    }
}
