package com.example.demo.entity;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "TypeDelete")

public class TypeDelete {

    @Id
    @SequenceGenerator(name="TypeDelete_seq",sequenceName="TypeDelete_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TypeDelete_seq")
    @Column(name = "TypeDelete_Id")
    @NotNull
    private  Long typedeleteid;
    @NotNull
    private  String typtD;

    public void setId(Long typedeleteid){this.typedeleteid = typedeleteid;}  public Long getId(){return typedeleteid;}
    public void setTyptD(String typtD){this.typtD = typtD;}  public String getTyptD(){return typtD;}
}

