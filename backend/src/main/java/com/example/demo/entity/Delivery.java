package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private int peice;
    private String statusName;
    private String staffName;

    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;
    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;
    @OneToOne(fetch = FetchType.EAGER)
    private CoffeeDelivery coffeeDelivery;





}
