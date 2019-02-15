package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Setter@Getter@NoArgsConstructor
@Table(name = "POINT")
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq",sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "point_seq")
    @Column(name = "point",unique = true,nullable = false)

    private
    @NotNull
    Long id;

    private
    @NotNull
    @Size(max = 50,min = 2)
    String other;

    @Temporal(TemporalType.DATE)
    @NotNull
    Date date;


//    @NotNull
//    @ManyToOne(fetch = FetchType.EAGER, targetEntity = ReservationRoomEntity.class)
//    @JoinColumn(name="reservationRoomId")
//    public ReservationRoomEntity newReservationRoomEntity;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Addpoint.class)
        @JoinColumn(name="addpoint")
    private Addpoint addpoint;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name="member")
 private Member member;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name="staff")
     private Staff staff;

//    public Point(){}
//
//    public Point(String other,Date date,Addpoint addpoint,Member member,Staff staff){
//        this.other = other;
//        this.date = date;
//
//        this.addpoint = addpoint;
//        this.member = member;
//        this.staff = staff;
//
//    }
//    public void setId(Long id){this.id = id;} public Long getId(){return id;}
//
//    public void setOther(String other){this.other = other;} public String getOther(){return other;}
//
//    public void setDate(Date date){this.date = date;} public Date getDate(){return date;}
//
//    public void setAddpoint(Addpoint addpoint)
//    {
//        this.addpoint = addpoint;
//    }
//
//    public Addpoint getAddpoint() {
//        return addpoint;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setStaff(Staff staff) {
//        this.staff = staff;
//    }
//
//    public Staff getStaff() { return staff; }
}
