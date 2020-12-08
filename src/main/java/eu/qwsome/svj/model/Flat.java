package eu.qwsome.svj.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * @author Lukáš Kvídera
 */
@Entity
@Table(name = "flat")
public class Flat {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  private String number;
  private Integer addressId;

  @OneToMany(
    mappedBy = "flat",
    cascade = CascadeType.ALL
  )
  private List<Ownership> ownerships;

  public Integer getId() {
    return this.id;
  }

  public void setId(final Integer id) {
    this.id = id;
  }

  public String getNumber() {
    return this.number;
  }

  public void setNumber(final String number) {
    this.number = number;
  }

  public Integer getAddressId() {
    return this.addressId;
  }

  public void setAddressId(final Integer addressId) {
    this.addressId = addressId;
  }


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
      ", address=" + this.addressId +
      '}';
  }
}
