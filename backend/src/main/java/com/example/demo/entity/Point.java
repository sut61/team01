package com.example.demo.entity;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@ToString
@EqualsAndHashCode
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq",sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "point_seq")

    private @NonNull
    Long id;
    private String other;

//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = MessengerArea.class)
//    @JoinColumn(name = "AREA_ID", insertable = true)
//    private MessengerArea paidArea;

    @Temporal(TemporalType.DATE)
    private @io.micrometer.core.lang.NonNull
    Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    private Addpoint addpoint;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Billxy billxy;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member member;

    @ManyToOne(fetch = FetchType.EAGER)
    private Staff staff;

    public Point(){}

    public Point(String other,Date date,Addpoint addpoint,Member member,Staff staff){
        this.other = other;
        this.date = date;

        this.addpoint = addpoint;
//        this.billxy = billxy;
        this.member = member;
        this.staff = staff;

    }
    public void setId(Long id){this.id = id;} public Long getId(){return id;}

    public void setOther(String other){this.other = other;} public String getOther(){return other;}

    public void setDate(Date date){this.date = date;} public Date getDate(){return date;}

    //Relationship between Entity
    public void setAddpoint(Addpoint addpoint)
    {
        this.addpoint = addpoint;
    }

    public Addpoint getAddpoint() {
        return addpoint;
    }

//    public void setBillxy(Billxy billxy) {
//        this.billxy = billxy;
//    }
//
//    public Billxy getBillxy() {
//        return billxy;
//    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Staff getStaff() {
        return staff;
    }
}
