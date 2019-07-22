package eu.qwsome.svj.features.ownership;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Arrays;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class OwnershipController {

  private static final Logger LOG = LoggerFactory.getLogger(OwnershipController.class);

  private final OwnershipService ownershipService;

  @FXML
  private ListView<OwnershipDto> listOfOwners;
  @FXML
  private ComboBox<OwnerDto> ownerToAddComboBox;

  @FXML
  private ComboBox<OwnershipType> typeOfOwnershipComboBox;

  private int flatId;
  private OwnerDto currentlySelectedOwnerToAdd;

  @Autowired
  public OwnershipController(final OwnershipService ownershipService) {
    this.ownershipService = ownershipService;
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");
    this.typeOfOwnershipComboBox.setItems(FXCollections.observableList(Arrays.asList(OwnershipType.values())));
  }

  public void displayOwnershipFor(final int id) {
    this.flatId = id;
    final ObservableList<OwnershipDto> ownersOfFlat = this.ownershipService.findByFlatId(id);
    this.listOfOwners.setItems(ownersOfFlat);
    this.listOfOwners.setCellFactory(param -> new OwnershipListCell());

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
    final OwnershipType ownershipType = this.typeOfOwnershipComboBox.getSelectionModel().getSelectedItem();
    this.ownershipService.addOwnerTo(this.flatId, this.currentlySelectedOwnerToAdd.getId(), ownershipType);
    this.listOfOwners.getItems().add(
      new OwnershipDto(
        new OwnerDto(
          this.currentlySelectedOwnerToAdd.getId(),
          this.currentlySelectedOwnerToAdd.getFirstName(),
          this.currentlySelectedOwnerToAdd.getLastName(),
          this.currentlySelectedOwnerToAdd.getAnotherNames(),
          this.currentlySelectedOwnerToAdd.getBirthDate(),
          this.currentlySelectedOwnerToAdd.getEmail(),
          this.currentlySelectedOwnerToAdd.getPhone(),
          this.currentlySelectedOwnerToAdd.getNotice()
        ),
        ownershipType
      )
    );
  }
}
