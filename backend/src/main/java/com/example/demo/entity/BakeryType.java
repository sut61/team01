package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "BakeryType")
public class BakeryType {

    @Id
    @SequenceGenerator(name = "BakeryType_seq",sequenceName = "BakeryType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="BakeryType_seq")
    @Column(name = "BakeryType_ID")
    private Long bakeryid;
    private @NonNull String bakery;
}
