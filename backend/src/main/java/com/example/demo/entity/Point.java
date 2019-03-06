package com.example.demo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Entity
@Data
@Setter@Getter@NoArgsConstructor
@Table(name = "POINT")
public class Point {
    @Id
    @SequenceGenerator(name = "point_seq",sequenceName = "point_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "point_seq")
    @Column(name = "id",unique = true,nullable = false)

    private
    @NotNull
    Long id;

    private
    @NotNull
    @Size(max = 50,min = 2)
    @Pattern(regexp = "\\w+")
    String other;

    private
    @NotNull
    @Positive
    @Max(value = 5000)
    @Min(value = 1)
    int pointNumber;

    @Temporal(TemporalType.DATE)
    @NotNull
    Date date;

    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Addpoint.class)
        @JoinColumn(name="addpoint")
    private Addpoint addpoint;
    @NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Member.class)
    @JoinColumn(name="member")
 private Member member;
@NotNull
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Staff.class)
    @JoinColumn(name="staff")
     private Staff staff;


}
