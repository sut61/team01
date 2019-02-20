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
    @Column(name = "id",unique = true,nullable = false)

    private @NotNull
    Long id;

private
@NotNull
@Max(value = 5000)
@Positive
int amount;

    private
    @NotNull
    String category;
@NotNull
@ManyToOne(fetch = FetchType.EAGER)
private Member member;
@NotNull
@ManyToOne(fetch = FetchType.EAGER)
private Staff staff;
@NotNull
@ManyToOne(fetch = FetchType.EAGER)
private Typereward typereward;



}