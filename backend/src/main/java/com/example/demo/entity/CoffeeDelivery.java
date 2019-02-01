package com.example.demo.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "CoffeeDelivery")
public class CoffeeDelivery {
    @Id
    @SequenceGenerator(name="coffeeDelivery_seq",sequenceName="coffeeDelivery_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="coffeeDelivery_seq")
    @Column(nullable=false)
    @NotNull
    private  Long coffeeDeliveryId;
    private  double latitude;
    private  double longitude;
    @NotNull
    private  String name;
    private  int price;

    @ManyToOne(fetch = FetchType.EAGER)
         private  Member member;
    @ManyToOne(fetch = FetchType.EAGER)
        private ServiceType serviceType;
    @ManyToOne(fetch= FetchType.EAGER)
     private Manu manu;



}
