package eu.qwsome.svj.features.ownership;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * @author Lukáš Kvídera
 */
class OwnershipDto {
  private final ObjectProperty<OwnerDto> owner;
  private final ObjectProperty<OwnershipType> ownershipType;

  OwnershipDto(final OwnerDto owner, final OwnershipType ownershipType) {
    this.owner = new SimpleObjectProperty<>(owner);
    this.ownershipType = new SimpleObjectProperty<>(ownershipType);
  }

  OwnerDto getOwner() {
    return this.owner.get();
  }

  OwnershipType getOwnershipType() {
    return this.ownershipType.get();
  }

  @Override
  public String toString() {
    return "OwnershipDto{" +
      ", owners='" + this.owner + '\'' +
      '}';
  }
}
