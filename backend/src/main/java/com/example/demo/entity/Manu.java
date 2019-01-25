package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "Manu")
public class Manu {
    @Id
    @GeneratedValue
    private  int manuid;
    private @NonNull String name;
    private @NonNull int price;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ManuType.class)
    @JoinColumn(name = "ManuType_Id")
    private ManuType manutype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CoffeeType.class)
    @JoinColumn(name = "CoffeeType_ID")
    private CoffeeType coffeetype;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = BakeryType.class)
    @JoinColumn(name = "BakeryType_ID")
    private BakeryType bakerytype;

}
