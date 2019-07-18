package eu.qwsome.svj.features.flat;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Lukáš Kvídera
 */
@Entity
@DynamicUpdate
public class Flat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String number;
  private String address;


  public Integer getId() {
    return this.id;
  }

  void setId(final Integer id) {
    this.id = id;
  }

  public String getNumber() {
    return this.number;
  }

  void setNumber(final String number) {
    this.number = number;
  }

  public String getAddress() {
    return this.address;
  }

  void setAddress(final String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Flat{" +
      "number='" + this.number + '\'' +
      ", address='" + this.address + '\'' +
      '}';
  }
}
