package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "Manu")
public class Manu {

    @Id
    @SequenceGenerator(name = "manu_seq",sequenceName = "manu_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "manu_seq")

    private  int manuid;
    @NotNull
    @Pattern(regexp = "[-A-Zก-๛]+")
    @Size(min = 2, max = 40 )
    private  String name;
    private int price;

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
