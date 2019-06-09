package eu.qwsome.svj.features.ownership;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Lukáš Kvídera
 */
public class OwnerDto {

  private final IntegerProperty id;
  private final StringProperty firstName;
  private final StringProperty lastName;

  public OwnerDto(final int id, final String firstName, final String lastName) {
    this.id = new SimpleIntegerProperty(id);
    this.firstName = new SimpleStringProperty(firstName);
    this.lastName = new SimpleStringProperty(lastName);
  }

  public int getId() {
    return this.id.get();
  }

  public IntegerProperty idProperty() {
    return this.id;
  }

  public void setId(final int id) {
    this.id.set(id);
  }

  public String getFirstName() {
    return this.firstName.get();
  }

  public StringProperty firstNameProperty() {
    return this.firstName;
  }

  public String getLastName() {
    return this.lastName.get();
  }

  public StringProperty lastNameProperty() {
    return this.lastName;
  }

  @Override
  public String toString() {
    return "OwnerDto{" +
      "id=" + this.id +
      ", firstName=" + this.firstName +
      ", lastName=" + this.lastName +
      '}';
  }
}
