package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.features.address.AddressService;
import eu.qwsome.svj.features.ownership.OwnershipController;
import eu.qwsome.svj.model.Address;
import eu.qwsome.svj.model.Flat;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class FlatsController {

  private static final Logger LOG = LoggerFactory.getLogger(FlatsController.class);

  private final FlatService flatService;
  private AddressService addressService;
  private final OwnershipController ownershipController;

  @FXML
  private ListView<Flat> flatList;

  @Autowired
  public FlatsController(
    final FlatService flatService,
    AddressService addressService,
    final OwnershipController ownershipController
  ) {
    this.flatService = flatService;
    this.addressService = addressService;
    this.ownershipController = ownershipController;
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");
    this.flatList.setItems(this.flatService.findAll());
    this.flatList.setCellFactory(listView ->
      new ListCell<>() {
        @Override
        public void updateItem(final Flat item, final boolean empty) {
          LOG.debug("updateItem(item={}, empty={}", item, empty);
          super.updateItem(item, empty);
          if (item == null) {
            setText(null);
          } else {
            setText(addressService.findById(item.getAddressId()).map(Address::asString).orElse("--") + " / Byt. č. " + item.getNumber());
          }
        }
      });
    this.flatList.setOnMouseClicked(event -> {
      final Flat selectedItem = this.flatList.getSelectionModel().getSelectedItem();
      if (selectedItem != null) {
        this.ownershipController.displayOwnershipFor(selectedItem.getId());
      }
    });

  }
}
