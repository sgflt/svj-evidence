package eu.qwsome.svj.features.ownership;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Lukáš Kvídera
 */
@Entity(name = "flat_for_ownership")
@Table(name = "flat")
public class Flat {

  private final IntegerProperty id = new SimpleIntegerProperty();

  private String number;
  private String address;


  private List<FlatOwner> owners;

  @Id
  public int getId() {
    return this.id.get();
  }

  public void setId(final int id) {
    this.id.set(id);
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

  @ManyToMany
  @JoinTable(
    name = "ownership",
    joinColumns = @JoinColumn(name = "flat_id"),
    inverseJoinColumns = @JoinColumn(name = "owner_id")
  )
  public List<FlatOwner> getOwners() {
    return this.owners;
  }

  public void setOwners(final List<FlatOwner> owners) {
    this.owners = owners;
  }

  @Override
  public String toString() {
    return "Flat{" +
      "id=" + this.id +
      ", number=" + this.number +
      ", address=" + this.address +
      ", owners=" + this.owners +
      '}';
  }
}
