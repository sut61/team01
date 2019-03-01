package com.example.demo.entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
//    @SequenceGenerator(name="coffeeDelivery_seq",sequenceName="coffeeDelivery_seq")
//    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="coffeeDelivery_seq")
    @GeneratedValue
    @Column(nullable=false)
    @NotNull
    private  Long coffeeDeliveryId;

    @Min(value = 14)
    private  double latitude;

    @Min(value = 100)
    private  double longitude;

    @NotNull
    @Pattern(regexp = "\\D+")
    private  String name;

    @NotNull
    @Min(value = 25)
    @Max(value = 200)
    private  int price;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
         private  Member member;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
        private ServiceType serviceType;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
     private Manu manuid;

}
