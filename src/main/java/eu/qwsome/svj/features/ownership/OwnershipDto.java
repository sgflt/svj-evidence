package eu.qwsome.svj.features.ownership;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

/**
 * @author Lukáš Kvídera
 */
public class OwnershipDto {
  private final StringProperty address;
  private final ListProperty<OwnerDto> owners;

  OwnershipDto(final String address, final ObservableList<OwnerDto> owners) {
    this.address = new SimpleStringProperty(address);
    this.owners = new SimpleListProperty<>(owners);
  }

  StringProperty getAddress() {
    return this.address;
  }

  public ListProperty<OwnerDto> getOwners() {
    return this.owners;
  }

  @Override
  public String toString() {
    return "OwnershipDto{" +
      "address='" + this.address + '\'' +
      ", owners='" + this.owners + '\'' +
      '}';
  }
}
