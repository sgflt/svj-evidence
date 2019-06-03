package eu.qwsome.svj.controller;

import eu.qwsome.svj.entity.FlatOwner;
import eu.qwsome.svj.service.FlatOwnerService;
import eu.qwsome.svj.view.SceneManager;
import eu.qwsome.svj.view.View;
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
public class EditFlatOwnerController {

  private static final Logger LOG = LoggerFactory.getLogger(EditFlatOwnerController.class);


  private final FlatOwnerService flatOwnerService;
  private final SceneManager sceneManager;

  @FXML
  private TextField firstNameInput;

  @FXML
  private TextField lastNameInput;

  @FXML
  private Button saveFlatOwnerButton;

  public EditFlatOwnerController(final FlatOwnerService flatOwnerService, final SceneManager sceneManager) {
    this.flatOwnerService = flatOwnerService;
    this.sceneManager = sceneManager;
  }


  @FXML
  public void onSaveFlatOwner() {
    LOG.trace("onSaveFlatOwner()");
    final FlatOwner flatOwner = new FlatOwner();
    flatOwner.setFirstName(this.firstNameInput.getText());
    flatOwner.setLastName(this.lastNameInput.getText());
    this.flatOwnerService.save(flatOwner);
    this.sceneManager.switchTo(View.MAIN, this.saveFlatOwnerButton.getScene());
  }

}
