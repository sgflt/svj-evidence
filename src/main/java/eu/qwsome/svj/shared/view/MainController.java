package eu.qwsome.svj.shared.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class MainController {

  @FXML
  private Button addFlatOwnerButton;

  private final SceneManager sceneManager;

  @Autowired
  public MainController(final SceneManager sceneManager) {
    this.sceneManager = sceneManager;
  }

  @FXML
  public void onCreateFlatOwner() {
    this.sceneManager.switchTo(View.FLAT_OWNER_EDIT, this.addFlatOwnerButton.getScene());
  }

  @FXML
  public void onCreateFlat() {
    this.sceneManager.switchTo(View.FLAT_CREATE, this.addFlatOwnerButton.getScene());
  }

  @FXML
  public void onCreateAddress() {
    this.sceneManager.switchTo(View.ADDRESS_CREATE, this.addFlatOwnerButton.getScene());
  }
}
