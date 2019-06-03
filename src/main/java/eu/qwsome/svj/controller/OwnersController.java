package eu.qwsome.svj.controller;

import eu.qwsome.svj.entity.FlatOwner;
import eu.qwsome.svj.service.FlatOwnerService;
import eu.qwsome.svj.view.SceneManager;
import eu.qwsome.svj.view.View;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class OwnersController {

  private final FlatOwnerService flatOwnerService;
  private final SceneManager sceneManager;

  @FXML
  private TableColumn<FlatOwner, String> flatOwnerNameTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerLastNameTableColumn;
  @FXML
  private TableView<FlatOwner> ownersTableView;

  @Autowired
  public OwnersController(final FlatOwnerService flatOwnerService, final SceneManager sceneManager) {
    this.flatOwnerService = flatOwnerService;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void initialize() {
    this.flatOwnerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    this.flatOwnerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

    final ObservableList<FlatOwner> flatOwners = this.flatOwnerService.findAll();
    this.ownersTableView.setItems(flatOwners);
  }

  @FXML
  public void onCreateFlatOwner() {
    this.sceneManager.switchTo(View.FLAT_OWNER_EDIT, this.ownersTableView.getScene());
  }
}
