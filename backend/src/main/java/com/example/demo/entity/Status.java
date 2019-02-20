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
@Table( name = "Status")
public class Status {


    @Id
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="status_seq")
    @NotNull
    private Long statusId;
    @NotNull
    private String statusName;
}
