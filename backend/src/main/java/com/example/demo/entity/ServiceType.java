package com.example.demo.entity;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table( name = "ServiceType")
public class ServiceType {

    @Id
    @SequenceGenerator(name="orderType_seq",sequenceName="orderType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="orderType_seq")
    private @NotNull Long serviceTypeId;
    private  String service;



}
