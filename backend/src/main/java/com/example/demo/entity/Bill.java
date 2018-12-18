package com.example.demo.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "Bill")
public class Bill {

    @Id
    @SequenceGenerator(name="bill_seq",sequenceName="bill_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bill_seq")

    @Column(name = "Bill_Id")
    private @NonNull Long billid;
    
}


