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

    @Min(value = 14)
    private double latitude;

    @Min(value = 100)
    private double longitude;

    @NotNull
    private String name;

    @NotNull
    @Min(value = 25)
    @Max(value = 200)
    private  double price;

    @Pattern(regexp = "\\D+")
    private String statusName;

    @NotNull
    private String staffName;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Status status;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

    @NotNull
    @OneToOne(fetch = FetchType.EAGER )
    private CoffeeDelivery coffeeDelivery;


}
