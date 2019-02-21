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
    private @NotNull String note;
    private @NotNull Integer cash;
    private @NotNull Integer discount;
    private @NotNull Integer change;

    @Temporal(TemporalType.DATE)
    @NotNull
    Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private CoffeeOrder coffeeorder;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;


}