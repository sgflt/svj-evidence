package eu.qwsome.svj.features.owner;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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
public class FlatOwner {

  private final IntegerProperty id = new SimpleIntegerProperty();

  private final StringProperty firstName = new SimpleStringProperty();
  private final StringProperty lastName = new SimpleStringProperty();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return this.id.get();
  }

  public void setId(final int id) {
    this.id.set(id);
  }

  public final String getFirstName() {
    return this.firstName.get();
  }

  final void setFirstName(final String firstName) {
    this.firstName.set(firstName);
  }

  public final String getLastName() {
    return this.lastName.get();
  }

  void setLastName(final String lastName) {
    this.lastName.set(lastName);
  }

  @Override
  public String toString() {
    return "FlatOwner{" +
      "firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      '}';
  }
}
