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


/**
 * @author Lukáš Kvídera
 */
public class OwnersController {

  private final FlatOwnerService flatOwnerService;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerNameTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerLastNameTableColumn;

  @FXML
  private TableView<FlatOwner> ownersTableView;

  public OwnersController() {
    this.flatOwnerService = FlatOwnerService.getInstance();
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
    SceneManager.switchTo(View.FLAT_OWNER_EDIT, this.ownersTableView.getScene());
  }
}
