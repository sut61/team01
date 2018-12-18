package com.example.demo.entity;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;

@Entity
@Getter @Setter
@NoArgsConstructor
@ToString @EqualsAndHashCode
public class CoffeeDelivery {
    @Id @GeneratedValue
    private @NonNull long coffeeDeliveryID;

    private String address;
    private int number;


}
