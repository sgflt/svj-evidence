package eu.qwsome.svj.features.owner;

import eu.qwsome.svj.model.FlatOwner;
import eu.qwsome.svj.shared.view.SceneManager;
import eu.qwsome.svj.shared.view.View;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class FlatOwnerController {

  private final FlatOwnerService flatOwnerService;
  private final SceneManager sceneManager;

  @FXML
  private TableColumn<FlatOwner, String> flatOwnerNameTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerLastNameTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerAnotherNamesTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerPhoneTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerEmailTableColumn;
  @FXML
  private TableColumn<FlatOwner, String> flatOwnerNoteTableColumn;
  @FXML
  private TableView<FlatOwner> ownersTableView;

  @Autowired
  public FlatOwnerController(final FlatOwnerService flatOwnerService, final SceneManager sceneManager) {
    this.flatOwnerService = flatOwnerService;
    this.sceneManager = sceneManager;
  }


  private static FlatOwner getSelectedFlatOwner(final CellEditEvent<FlatOwner, String> event) {
    return event.getTableView()
      .getItems()
      .get(event.getTablePosition().getRow());
  }

  @FXML
  public void initialize() {
    this.flatOwnerNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
    this.flatOwnerNameTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setFirstName(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerLastNameTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerLastNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
    this.flatOwnerLastNameTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setLastName(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerAnotherNamesTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerAnotherNamesTableColumn.setCellValueFactory(new PropertyValueFactory<>("anotherNames"));
    this.flatOwnerAnotherNamesTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setAnotherNames(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerPhoneTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerPhoneTableColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
    this.flatOwnerPhoneTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setPhone(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerEmailTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerEmailTableColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    this.flatOwnerEmailTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setEmail(event.getNewValue());
        this.flatOwnerService.save(flatOwner);
      }
    );

    this.flatOwnerNoteTableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
    this.flatOwnerNoteTableColumn.setCellValueFactory(new PropertyValueFactory<>("notice"));
    this.flatOwnerNoteTableColumn.setOnEditCommit(
      event -> {
        final FlatOwner flatOwner = getSelectedFlatOwner(event);
        flatOwner.setNotice(event.getNewValue());
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
