package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.features.address.AddressService;
import eu.qwsome.svj.model.Address;
import eu.qwsome.svj.model.Flat;
import eu.qwsome.svj.shared.view.SceneManager;
import eu.qwsome.svj.shared.view.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * @author Lukáš Kvídera
 */
@Controller
public class CreateFlatController {

  private static final Logger LOG = LoggerFactory.getLogger(CreateFlatController.class);


  private final FlatService flatService;
  private AddressService addressService;
  private final SceneManager sceneManager;

  @FXML
  private TextField flatNumber;

  @FXML
  private ComboBox<Address> addressComboBox;

  @FXML
  private Button saveFlatButton;

  public CreateFlatController(final FlatService flatService, AddressService addressService, final SceneManager sceneManager) {
    this.flatService = flatService;
    this.addressService = addressService;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");
    this.addressComboBox.setItems(this.addressService.findAll());
    this.addressComboBox.setCellFactory(listView ->
      new ListCell<>() {
        @Override
        public void updateItem(final Address item, final boolean empty) {
          LOG.debug("updateItem(item={}, empty={}", item, empty);
          super.updateItem(item, empty);
          if (item == null) {
            setText(null);
          } else {
            setText(item.asString());
          }
        }
      });
  }


  @FXML
  public void onSaveFlat() {
    LOG.trace("onSaveFlatOwner()");
    final Flat flat = new Flat();
    flat.setNumber(this.flatNumber.getText());
    flat.setAddressId(this.addressComboBox.getSelectionModel().getSelectedItem().getAddressId());
    this.flatService.save(flat);
    this.sceneManager.switchTo(View.MAIN, this.saveFlatButton.getScene());
  }

}
