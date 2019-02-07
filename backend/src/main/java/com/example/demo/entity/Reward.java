package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;
import javax.validation.constraints.Size;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
public class Reward{

    @Id
    @SequenceGenerator(name = "rewards_seq",sequenceName = "rewards_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rewards_seq")

    private @NonNull
    Long id;

//    private @Size(max = 25,min = 2) int amount;
//
//    @Temporal(TemporalType.DATE)
//    private @io.micrometer.core.lang.NonNull
//    Date date;

    private @NonNull String category;


    //Relation between Entity



//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MessengerArea.class)
//    @JoinColumn(name = "AREA_ID", insertable = true)
//    private MessengerArea paidArea;

// @ManyToOne(fetch = FetchType.EAGER)
// private Member member;



@ManyToOne(fetch = FetchType.EAGER)
private Member member;

@ManyToOne(fetch = FetchType.EAGER)
private Staff staff;

@ManyToOne(fetch = FetchType.EAGER)
private Typereward typereward;


    public Reward(){}

    public Reward(String category,Member member,Staff staff,Typereward typereward){
//        this.amount = amount;
//        this.date = date;
        this.category = category;

        this.member = member;
        this.staff = staff;
        this.typereward = typereward;


    }

    public void setId(Long id){this.id = id;}  public Long getId(){return id;}

//    public void setAmount(int amount){this.amount = amount;}  public int getAmount(){return amount;}

//    public void setDate(Date date){this.date = date;}  public Date setDate(){return date;}

    public void setCategory(String category){this.category = category;}   public String getCategory(){return category;}


    //set && get Entity


    public void setMember(Member member){this.member = member;}  public Member getMember(){return member;}

    public void setStaff(Staff staff){this.staff = staff;}  public Staff getStaff(){return staff;}

    public void setTypereward(Typereward typereward){this.typereward = typereward;}  public Typereward getTypereward(){return typereward;}

}