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
@Table(name = "Cancel")

public class Cancel {

    @Id
    @SequenceGenerator(name="cancel_seq",sequenceName="cancel_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cancel_seq")
    @Column(name = "Cancel_Id")

    private @NotNull Long cancelid;
    // private @NotNull String note;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "Staff_id",insertable = true)
    private Staff staff;

    @OneToOne (fetch = FetchType.EAGER, targetEntity = TypeDelete.class)
    @JoinColumn(name = "TypeDelete_id",insertable = true)
    private TypeDelete typeDelete;


}

