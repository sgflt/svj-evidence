package eu.qwsome.svj.model;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * @author Lukáš Kvídera
 */
@Entity
@DynamicUpdate
public class FlatOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;
  private String lastName;
  private String anotherNames;
  private LocalDate birthDate;
  private String email;
  private String notice;
  private String phone;


  public Integer getId() {
    return this.id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  public String getAnotherNames() {
    return this.anotherNames;
  }

  public void setAnotherNames(final String anotherNames) {
    this.anotherNames = anotherNames;
  }

  public LocalDate getBirthDate() {
    return this.birthDate;
  }

  void setBirthDate(final LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getNotice() {
    return this.notice;
  }

  public void setNotice(final String notice) {
    this.notice = notice;
  }

  public String getPhone() {
    return this.phone;
  }

  public void setPhone(final String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "FlatOwner{" +
      "id=" + this.id +
      ", firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      ", anotherNames='" + this.anotherNames + '\'' +
      ", birthDate=" + this.birthDate +
      ", email='" + this.email + '\'' +
      ", notice='" + this.notice + '\'' +
      ", phone='" + this.phone + '\'' +
      '}';
  }
}
