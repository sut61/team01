package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "Nametype")
public class Nametype {
    @Id
    @SequenceGenerator(name="nametype_seq",sequenceName="nametype_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="nametype_seq")

    @Column(name = "Nametype_Id")
    private @NonNull Long nid;
    private @NonNull String nameDoc;

}

