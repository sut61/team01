package com.example.demo.entity;

import lombok.*;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @NotNull
    private  Long cancelid;
    

    @Temporal(TemporalType.DATE)
    
    @NotNull
    Date date;
    @NotNull
    @Pattern(regexp = "[-a-zก-๛]+")
    private  String note;
    @NotNull
    private  String userDeleted;

    
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "Staff_id",insertable = true)
    private Staff staff;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = TypeDelete.class)
    @JoinColumn(name = "TypeDelete_id",insertable = true)
    private TypeDelete typeDelete;






}

