package eu.qwsome.svj.features.address;

import eu.qwsome.svj.model.Address;
import eu.qwsome.svj.shared.view.SceneManager;
import eu.qwsome.svj.shared.view.View;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

/**
 * @author Lukáš Kvídera
 */
@Controller
public class CreateAddressController {

  private static final Logger LOG = LoggerFactory.getLogger(CreateAddressController.class);


  private final AddressService service;
  private final SceneManager sceneManager;

  @FXML
  private TextField municipalityInput;
  @FXML
  private TextField municipalityPartInput;
  @FXML
  private TextField streetInput;
  @FXML
  private TextField houseNumberInput;
  @FXML
  private Button saveAddressButton;

  public CreateAddressController(final AddressService service, final SceneManager sceneManager) {
    this.service = service;
    this.sceneManager = sceneManager;
  }


  @FXML
  public void onSaveAddress() {
    LOG.trace("onSaveAddress()");
    final Address address = new Address();
    address.setMunicipality(this.municipalityInput.getText());
    address.setMunicipalityPart(this.municipalityPartInput.getText());
    address.setStreet(this.streetInput.getText());
    address.setHouseNumber(this.houseNumberInput.getText());
    this.service.save(address);
    this.sceneManager.switchTo(View.MAIN, this.saveAddressButton.getScene());
  }

}
