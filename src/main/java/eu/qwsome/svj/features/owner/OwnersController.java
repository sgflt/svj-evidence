package eu.qwsome.svj.features.owner;

import eu.qwsome.svj.shared.view.SceneManager;
import eu.qwsome.svj.shared.view.View;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
class OwnersController {

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
    this.flatOwnerNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    this.flatOwnerNameTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = event.getTableView()
          .getItems()
          .get(event.getTablePosition().getRow());
        flatOwner.setFirstName(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerLastNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    this.flatOwnerLastNameTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = event.getTableView()
          .getItems()
          .get(event.getTablePosition().getRow());
        flatOwner.setLastName(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    final ObservableList<FlatOwner> flatOwners = this.flatOwnerService.findAll();
    this.ownersTableView.setItems(flatOwners);
    this.ownersTableView.setEditable(true);
  }

  @FXML
  public void onCreateFlatOwner() {
    this.sceneManager.switchTo(View.FLAT_OWNER_EDIT, this.ownersTableView.getScene());
  }
}
