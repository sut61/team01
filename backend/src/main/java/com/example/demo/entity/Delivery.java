package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "Delivery")
public class Delivery {

    @Id
    @SequenceGenerator(name="Delivery_seq",sequenceName="Delivery_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Delivery_seq")
    @NotNull
    private Long deliveryId;
    private double latitude;
    private double longitude;
    @NotNull
    private String name;
    @NotNull
  //  @Pattern(regexp = "[\\D*]")
    @Min(value = 25)
    @Max(value = 200)
    private int price;
    private String statusName;
//    @Pattern(regexp = "([^0-9])")
    private String staffName;
    private String note;


    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;
    @OneToOne(fetch = FetchType.EAGER)
    private CoffeeDelivery coffeeDelivery;

    public void setStaff(Long staff) {}



}
