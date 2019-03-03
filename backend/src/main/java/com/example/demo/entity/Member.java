package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "Member")
public class Member {

    @Id
    @SequenceGenerator(name="member_seq",sequenceName="member_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="member_seq")
    @Column(name = "Member_Id")
    
    @NotNull
    private  Long meid;

    @NotNull
    @NotBlank
    @Column(unique = true)
    @Length (max=10) 
    private  String password;

    @NotNull
    @Pattern(regexp = "\\w+")
    private @Size(min = 1, max = 10)  String user;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private  String address;

    @NotNull
    @NotBlank
    @Column(unique = true) 
    private  String nameM;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "Gender_id",insertable = true)
    @NotNull private Gender g;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = Nametype.class)
    @JoinColumn(name = "Nametype_id",insertable = true)
    @NotNull private Nametype n;

    @ManyToOne (fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_id",insertable = true)
    @NotNull private Province p;


}

