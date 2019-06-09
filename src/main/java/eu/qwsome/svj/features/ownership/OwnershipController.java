package eu.qwsome.svj.features.ownership;

import javafx.beans.property.SimpleListProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Optional;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class OwnershipController {

  private static final Logger LOG = LoggerFactory.getLogger(OwnershipController.class);

  private final OwnershipService ownershipService;

  @FXML
  private ListView<OwnerDto> listOfOwners;
  @FXML
  private ComboBox<OwnerDto> ownerToAddComboBox;

  private int flatId;
  private OwnerDto currentlySelectedOwnerToAdd;

  @Autowired
  public OwnershipController(final OwnershipService ownershipService) {
    this.ownershipService = ownershipService;
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");
  }

  public void displayOwnershipFor(final int id) {
    this.flatId = id;
    final Optional<OwnershipDto> ownersOfFlat = this.ownershipService.findByFlatId(id);
    this.listOfOwners.setItems(ownersOfFlat.map(OwnershipDto::getOwners).orElseGet(SimpleListProperty::new));
    this.listOfOwners.setCellFactory(param ->
      new ListCell<>() {
        @Override
        public void updateItem(final OwnerDto item, final boolean empty) {
          LOG.debug("updateItem(item={}, empty={}", item, empty);
          super.updateItem(item, empty);
          if (empty) {
            setText(null);
          } else {
            setText(item.getFirstName());
          }
        }
      });

    this.ownerToAddComboBox.setItems(this.ownershipService.findAllOwners());
    this.ownerToAddComboBox.setButtonCell(getComboBoxListCell());
    this.ownerToAddComboBox.setCellFactory(param -> getComboBoxListCell());
    this.ownerToAddComboBox.getSelectionModel().selectedItemProperty().addListener(
      (observable, oldValue, newValue) -> {
        LOG.debug("observable={}, oldValue={}, newValue={}", observable, oldValue, newValue);
        if (newValue != null) {
          this.currentlySelectedOwnerToAdd = newValue;
        }
      }
    );

  }

  private ListCell<OwnerDto> getComboBoxListCell() {
    return new ListCell<>() {
      @Override
      public void updateItem(final OwnerDto item, final boolean empty) {
        LOG.debug("updateItem(item={}, empty={}", item, empty);
        super.updateItem(item, empty);
        if (empty) {
          setText(null);
        } else {
          setText(item.getFirstName());
        }
      }
    };
  }

  public void addOwnerToFlat() {
    this.ownershipService.addOwnerTo(this.flatId, this.currentlySelectedOwnerToAdd.getId());
    this.listOfOwners.getItems().add(this.currentlySelectedOwnerToAdd);
  }
}
