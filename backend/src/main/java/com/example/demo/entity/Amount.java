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
@Table(name = "Amount")
public class Amount {

    @Id
    @SequenceGenerator(name="amount_seq",sequenceName="amount_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="amount_seq")
    @Column(name = "Amount_Id")

    private @NotNull Long amountid;
    private @NotNull int amount;
}
