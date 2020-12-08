package eu.qwsome.svj.features.address;

import eu.qwsome.svj.model.Address;
import eu.qwsome.svj.shared.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class AddressController {

  private static final Logger LOG = LoggerFactory.getLogger(AddressController.class);

  private final AddressService service;
  private final SceneManager sceneManager;

  @FXML
  private TableColumn<Address, String> municipalityColumn;
  @FXML
  private TableColumn<Address, String> municipalityPartColumn;
  @FXML
  private TableColumn<Address, String> streetColumn;
  @FXML
  private TableColumn<Address, String> houseNumberColumn;
  @FXML
  private TableView<Address> addressesView;

  public AddressController(
    final AddressService service,
    final SceneManager sceneManager
  ) {
    this.service = service;
    this.sceneManager = sceneManager;
  }

  private static Address getSelectedAddress(final CellEditEvent<Address, String> event) {
    return event.getTableView()
      .getItems()
      .get(event.getTablePosition().getRow());
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");

    this.municipalityColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.municipalityColumn.setCellValueFactory(new PropertyValueFactory<>("municipality"));
    this.municipalityColumn.setOnEditCommit(
      event -> {
        final Address flatOwner = getSelectedAddress(event);
        flatOwner.setMunicipality(event.getNewValue());
        this.service.save(flatOwner);
      }
    );

    this.municipalityPartColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.municipalityPartColumn.setCellValueFactory(new PropertyValueFactory<>("municipalityPart"));
    this.municipalityPartColumn.setOnEditCommit(
      event -> {
        final Address flatOwner = getSelectedAddress(event);
        flatOwner.setMunicipalityPart(event.getNewValue());
        this.service.save(flatOwner);
      }
    );

    this.streetColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.streetColumn.setCellValueFactory(new PropertyValueFactory<>("street"));
    this.streetColumn.setOnEditCommit(
      event -> {
        final Address flatOwner = getSelectedAddress(event);
        flatOwner.setStreet(event.getNewValue());
        this.service.save(flatOwner);
      }
    );

    this.houseNumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.houseNumberColumn.setCellValueFactory(new PropertyValueFactory<>("houseNumber"));
    this.houseNumberColumn.setOnEditCommit(
      event -> {
        final Address flatOwner = getSelectedAddress(event);
        flatOwner.setHouseNumber(event.getNewValue());
        this.service.save(flatOwner);
      }
    );

    this.addressesView.setItems(this.service.findAll());
    this.addressesView.setEditable(true);
  }
}
