package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Unit")

public class Unit {
    @Id
    @SequenceGenerator(name="unit_seq",sequenceName="unit_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="unit_seq")
    @Column(name = "Unit_Id")

    private @NotNull Long unitid;
    private @NotNull String unit;
}
