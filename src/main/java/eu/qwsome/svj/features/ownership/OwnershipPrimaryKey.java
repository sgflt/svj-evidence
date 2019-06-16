package eu.qwsome.svj.features.ownership;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author Lukáš Kvídera
 */
@Embeddable
public class OwnershipPrimaryKey implements Serializable {

  @Column(name = "owner_id")
  private Integer ownerId;

  @Column(name = "flat_id")
  private Integer flatId;

  public OwnershipPrimaryKey() {
  }

  public OwnershipPrimaryKey(final Integer flatId, final Integer ownerId) {
    this.flatId = flatId;
    this.ownerId = ownerId;
  }

  public Integer getOwnerId() {
    return this.ownerId;
  }

  public void setOwnerId(final Integer ownerId) {
    this.ownerId = ownerId;
  }

  public Integer getFlatId() {
    return this.flatId;
  }

  public void setFlatId(final Integer flatId) {
    this.flatId = flatId;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final OwnershipPrimaryKey that = (OwnershipPrimaryKey) o;
    return Objects.equals(this.ownerId, that.ownerId) &&
      Objects.equals(this.flatId, that.flatId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.ownerId, this.flatId);
  }
}
