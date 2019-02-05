package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Setter
@Getter
@EqualsAndHashCode
public class Staff{

    @Id
    @SequenceGenerator(name = "staff_seq",sequenceName = "staff_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "staff_seq")

    private Long staffId;
    private String staffName;
    private String username;
    private String password;

    public Staff(){}

    public Staff(String staffName){
        this.staffName = staffName;
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
