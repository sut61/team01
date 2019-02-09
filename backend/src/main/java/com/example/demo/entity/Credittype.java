package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Credittype")
public class Credittype {

    @Id
    @SequenceGenerator(name="credittype_seq",sequenceName="credittype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="credittype_seq")
    @Column(name = "Credittype_Id")

    private @NonNull Long creditid;
    private @NonNull String typename;
}
