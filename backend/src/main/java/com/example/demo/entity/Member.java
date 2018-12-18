package Team01.demoSpringboot.entity;


import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="Member")
public class Member {

  @Id
  @GeneratedValue
  private Long id;
  private @NonNull

  String name;
  private @NonNull

  String sex;
  private @NonNull

  String tel;
  private @NonNull

  String email;
  private @NonNull

  String address;
  private @NonNull

  String district;
  private @NonNull

  String province;


  public Member(String name, String sex, String tel, String email, String address, String district, String province) {
    this.name = name;
    this.sex = sex;
    this.email = email;
    this.address = address;
    this.district = district;
    this.province = province;
  }

}
