package com.example.demo.Entity;
import lombok.*;
import javax.persistence.*;
import java.util.Date;


@Entity
@ToString
@EqualsAndHashCode
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq",sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "point_seq")

    private Long id;
    private String name;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date date;

     Point(){}

     Point(String name,Date date){
         this.name = name;
         this.date = date;
     }
     public void setId(Long id){this.id = id;} public Long getId(){return id;}

     public void setName(String name){this.name = name;} public String getName(){return name;}

     public void setDate(Date date){this.date = date;} public Date getDate(){return date;}


}
