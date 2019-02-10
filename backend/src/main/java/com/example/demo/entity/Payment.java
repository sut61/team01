package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Payment")
public class Payment {

    @Id
    @SequenceGenerator(name="payment_seq",sequenceName="payment_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="payment_seq")
    @Column(name = "Payment_Id")

    private @NotNull Long payid;
    @Size(min = 1,max = 20)
    @Pattern(regexp = "[-0-9ก-๛]+")
    //@Pattern(regexp = "\\w+")
    private @NotNull String note;
    private @NotNull Integer money;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name = "Member_Id",insertable = true)
    private Member m;

   @ManyToOne(fetch = FetchType.EAGER, targetEntity = CoffeeOrder.class)
    @JoinColumn(name = "Coffeeorder_Id",insertable = true)
    private CoffeeOrder c;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name = "Staff_Id",insertable = true)
    private Staff b;


}