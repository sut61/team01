package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "CoffeeType")
public class CoffeeType {

    @Id
    @SequenceGenerator(name = "CoffeeType_seq",sequenceName = "CoffeeType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="CoffeeType_seq")
    @Column(name = "CoffeeType_ID")
    private Long coffeeid;
    private @NonNull String coffee;
}