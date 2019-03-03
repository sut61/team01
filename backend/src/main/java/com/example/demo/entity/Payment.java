package com.example.demo.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
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
    @Size(min = 2,max = 25)
    @Pattern(regexp = "[-0-9ก-๛]+")
    private @NotNull String note;
    private @NotNull Double cash;

    @Min(value = 1)
    @Max(value = 500)
    private @NotNull Double discount;
    private @NotNull Double change;

    @Temporal(TemporalType.DATE)
    @NotNull
    Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private CoffeeOrder coffeeorder;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;


}