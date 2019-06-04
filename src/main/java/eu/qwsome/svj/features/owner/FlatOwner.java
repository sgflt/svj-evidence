package eu.qwsome.svj.features.owner;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Lukáš Kvídera
 */
@Entity
public class FlatOwner {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String firstName;
  private String lastName;

  public String getFirstName() {
    return this.firstName;
  }

  void setFirstName(final String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  void setLastName(final String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "FlatOwner{" +
      "firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      '}';
  }
}