package eu.qwsome.svj.entity;

/**
 * @author Lukáš Kvídera
 */
public class FlatOwner {

  private final String firstName;
  private final String lastName;

  public FlatOwner(final String firstName, final String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  @Override
  public String toString() {
    return "FlatOwner{" +
      "firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      '}';
  }
}
