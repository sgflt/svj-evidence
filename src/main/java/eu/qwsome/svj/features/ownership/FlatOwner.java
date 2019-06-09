package eu.qwsome.svj.features.ownership;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

/**
 * @author Lukáš Kvídera
 */
@Entity
public class FlatOwner {

  private final IntegerProperty id = new SimpleIntegerProperty();

  private final StringProperty firstName = new SimpleStringProperty();
  private final StringProperty lastName = new SimpleStringProperty();
  private List<Flat> flats;

  @Id
  public int getId() {
    return this.id.get();
  }

  public void setId(final int id) {
    this.id.set(id);
  }

  public String getFirstName() {
    return this.firstName.get();
  }

  void setFirstName(final String firstName) {
    this.firstName.set(firstName);
  }

  public String getLastName() {
    return this.lastName.get();
  }

  void setLastName(final String lastName) {
    this.lastName.set(lastName);
  }

  @ManyToMany(mappedBy = "owners")
  public List<Flat> getFlats() {
    return this.flats;
  }

  public void setFlats(final List<Flat> flats) {
    this.flats = flats;
  }

  @Override
  public String toString() {
    return "Flat{" +
      "firstName='" + this.firstName + '\'' +
      ", lastName='" + this.lastName + '\'' +
      '}';
  }
}
