package eu.qwsome.svj.features.ownership;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 * @author Lukáš Kvídera
 */
@Entity
public class Ownership {

  @EmbeddedId
  private OwnershipPrimaryKey key;

  @ManyToOne
  @MapsId("flatId")
  @JoinColumn(name = "flat_id")
  private Flat flat;

  @ManyToOne
  @MapsId("ownerId")
  @JoinColumn(name = "owner_id")
  private FlatOwner flatOwner;

  private Character ownershipType;

  public Ownership() {

  }

  public Ownership(final Flat flat, final FlatOwner owner, final Character ownershipType) {
    this.flat = flat;
    this.flatOwner = owner;
    this.key = new OwnershipPrimaryKey(flat.getId(), owner.getId());
    this.ownershipType = ownershipType;
  }


  public OwnershipPrimaryKey getKey() {
    return this.key;
  }

  public void setKey(final OwnershipPrimaryKey key) {
    this.key = key;
  }

  public Flat getFlat() {
    return this.flat;
  }

  public FlatOwner getFlatOwner() {
    return this.flatOwner;
  }

  public Character getOwnershipType() {
    return this.ownershipType;
  }

  public void setOwnershipType(final Character ownershipType) {
    this.ownershipType = ownershipType;
  }
}
