package com.example.demo.entity;

import lombok.*;

import javax.validation.constraints.*;

import javax.persistence.*;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@Table(name = "REWARD")
public class Reward{

    @Id
    @SequenceGenerator(name = "rewards_seq",sequenceName = "rewards_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "rewards_seq")
    @Column(name = "point",unique = true,nullable = false)

    private @NotNull
    Long id;

private
@NotNull
//@Min(value = 1)
@Max(value = 5000)
@Positive
int amount;

    private
    @NotNull
//    @Size(max = 60,min = 1)
    String category;

@ManyToOne(fetch = FetchType.EAGER)
private Member member;

@ManyToOne(fetch = FetchType.EAGER)
private Staff staff;

@ManyToOne(fetch = FetchType.EAGER)
private Typereward typereward;

//    public Reward(){}
//
//    public Reward(String category,Member member,Staff staff,Typereward typereward,int amount){
//        this.amount = amount;
//        this.category = category;
//
//        this.member = member;
//        this.staff = staff;
//        this.typereward = typereward;
//    }
//
//    public void setId(Long id){this.id = id;}  public Long getId(){return id;}
//
//    public void setAmount(int amount){this.amount = amount;}  public int getAmount(){return amount;}
//
//    public void setCategory(String category){this.category = category;}   public String getCategory(){return category;}
//
//    public void setMember(Member member){this.member = member;}  public Member getMember(){return member;}
//
//    public void setStaff(Staff staff){this.staff = staff;}  public Staff getStaff(){return staff;}
//
//    public void setTypereward(Typereward typereward){this.typereward = typereward;}  public Typereward getTypereward(){return typereward;}

}