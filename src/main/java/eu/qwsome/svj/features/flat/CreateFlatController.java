package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.model.Flat;
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
public class CreateFlatController {

  private static final Logger LOG = LoggerFactory.getLogger(CreateFlatController.class);


  private final FlatService flatService;
  private final SceneManager sceneManager;

  @FXML
  private TextField flatNumber;

  @FXML
  private TextField flatAddress;

  @FXML
  private Button saveFlatButton;

  public CreateFlatController(final FlatService flatService, final SceneManager sceneManager) {
    this.flatService = flatService;
    this.sceneManager = sceneManager;
  }


  @FXML
  public void onSaveFlat() {
    LOG.trace("onSaveFlatOwner()");
    final Flat flat = new Flat();
    flat.setNumber(this.flatNumber.getText());
    flat.setAddress(this.flatAddress.getText());
    this.flatService.save(flat);
    this.sceneManager.switchTo(View.MAIN, this.saveFlatButton.getScene());
  }

}
