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
@Table(name = "Product")
public class Product {

    @Id
    @SequenceGenerator(name="product_seq",sequenceName="product_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_seq")
    @Column(name = "Product_Id")

    private @NotNull Long productid;
    private @NotNull String product;
}
