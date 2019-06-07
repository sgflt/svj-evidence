package eu.qwsome.svj.features.flat;

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
public class Flat {

  private final IntegerProperty id = new SimpleIntegerProperty();

  private final StringProperty number = new SimpleStringProperty();
  private final StringProperty address = new SimpleStringProperty();

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int getId() {
    return this.id.get();
  }

  public void setId(final int id) {
    this.id.set(id);
  }

  public final String getNumber() {
    return this.number.get();
  }

  final void setNumber(final String number) {
    this.number.set(number);
  }

  public final String getAddress() {
    return this.address.get();
  }

  void setAddress(final String address) {
    this.address.set(address);
  }

  @Override
  public String toString() {
    return "Flat{" +
      "number='" + this.number + '\'' +
      ", address='" + this.address + '\'' +
      '}';
  }
}
