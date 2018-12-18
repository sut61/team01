package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Manu")
public class Manu {

    @Id
    @GeneratedValue
    @Column(name = "Manu_ID")
    private @NonNull Long ID;
    private @NonNull String manu;

}
