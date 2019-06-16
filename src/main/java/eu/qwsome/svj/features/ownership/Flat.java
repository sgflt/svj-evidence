package eu.qwsome.svj.features.ownership;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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


  private List<Ownership> ownerships;

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

  @OneToMany(
    mappedBy = "flat",
    cascade = CascadeType.ALL
  )
  public List<Ownership> getOwnerships() {
    return this.ownerships;
  }

  public void setOwnerships(final List<Ownership> ownerships) {
    this.ownerships = ownerships;
  }


  public void addOwner(final FlatOwner owner, final Character ownershipType) {
    final Ownership ownership = new Ownership(this, owner, ownershipType);
    getOwnerships().add(ownership);
  }

  @Override
  public String toString() {
    return "Flat{" +
      "id=" + this.id +
      ", number=" + this.number +
      ", address=" + this.address +
      ", ownerships=" + this.ownerships +
      '}';
  }
}
