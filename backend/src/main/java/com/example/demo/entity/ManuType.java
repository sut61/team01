package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "ManuType")
public class ManuType {

    @Id
    @SequenceGenerator(name = "ManuType_seq",sequenceName = "ManuType_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="ManuType_seq")
    @Column(name = "ManuType_ID")

    private Long manutypeid;
    private @NonNull String manut;
}
