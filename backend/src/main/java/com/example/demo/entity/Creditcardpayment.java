package com.example.demo.entity;

import lombok.*;

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
@Table(name = "Creditcardpayment")
public class Creditcardpayment {

    @Id
    @SequenceGenerator(name="creditcard_seq",sequenceName="creditcard_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="creditcard_seq")
    @Column(name = "Creditcard_Id")

    private @NotNull Long creid;
    private @NotNull Long creditnumber;
    private  @NotNull Integer csc;

    @Temporal(TemporalType.DATE)
     @NotNull
    Date expireddate;

    @Pattern(regexp = "\\w+")
    private @Size(min = 1, max = 16) String creditname;

    private @NotNull Integer money;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @OneToOne(fetch = FetchType.EAGER)
    private CoffeeOrder coffeeorder;

    @OneToOne(fetch = FetchType.EAGER)
    private Credittype credittype;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

//    public void setMember(Member member) {
//        this.m = member;
//    }
//    public Member getMember() {
//        return m;
//    }
//
//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }
//    public Staff getStaff() {
//        return staff;
//    }
//
//    public void setCoffeeorder(CoffeeOrder coffeeorder) {
//        this.c = coffeeorder;
//    }
//    public CoffeeOrder getCoffeeorder() {
//        return c;
//    }
//
//    public void setCredittype(Credittype credittype) {
//        this.t = credittype;
//    }
//    public Credittype getCredittype() {
//        return t;
//    }
}
