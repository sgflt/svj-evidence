package eu.qwsome.svj.features.ownership;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * @author Lukáš Kvídera
 */
class OwnershipListCell extends ListCell<OwnershipDto> {

  @FXML
  private Label ownerFirstNameLabel;
  @FXML
  private Label ownerLastNameLabel;
  @FXML
  private Label ownershipTypeLabel;
  @FXML
  private HBox ownershipCell;


  OwnershipListCell() {
    final FXMLLoader loader = new FXMLLoader(getClass().getResource("/OwnershipListCell.fxml"));
    loader.setController(this);
    try {
      loader.load();
    } catch (final IOException e) {
      throw new IllegalStateException(e);
    }
    setGraphic(this.ownershipCell);
  }

  @Override
  protected void updateItem(final OwnershipDto item, final boolean empty) {
    super.updateItem(item, empty);

    if (empty || item == null) {
      setText(null);
      this.ownerFirstNameLabel.setText(null);
      this.ownerLastNameLabel.setText(null);
      this.ownershipTypeLabel.setText(null);
    } else {
      this.ownerFirstNameLabel.setText(item.getOwner().getFirstName());
      this.ownerLastNameLabel.setText(item.getOwner().getLastName());
      this.ownershipTypeLabel.setText(item.getOwnershipType().toString());
    }
  }
}
