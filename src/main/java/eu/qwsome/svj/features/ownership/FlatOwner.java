package eu.qwsome.svj.features.ownership;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Lukáš Kvídera
 */
@Entity(name = "flat_owner_for_ownership")
@Table(name = "flat_owner")
public class FlatOwner {

  @Id
  private Integer id;

  private String firstName;
  private String lastName;


  public int getId() {
    return this.id;
  }

  public void setId(final int id) {
    this.id = id;
  }

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
    return "Flat{" +
      "firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      '}';
  }
}
