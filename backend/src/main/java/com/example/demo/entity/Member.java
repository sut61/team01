package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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

    private @NotNull Long meid;
   // private @NonNull int gender;
   // private @NonNull int nametype;
   // private @NonNull int province;
    private @NotNull String password;
    @Pattern(regexp = "\\w+")
    private @Size(min = 1, max = 10)  String user;
    private @NotNull String address;
    private @NotNull String nameM;

    @OneToOne(fetch = FetchType.EAGER, targetEntity = Gender.class)
    @JoinColumn(name = "Gender_id",insertable = true)
    private Gender g;

    @OneToOne (fetch = FetchType.EAGER, targetEntity = Nametype.class)
    @JoinColumn(name = "Nametype_id",insertable = true)
    private Nametype n;

    @OneToOne (fetch = FetchType.EAGER, targetEntity = Province.class)
    @JoinColumn(name = "Province_id",insertable = true)
    private Province p;


}

