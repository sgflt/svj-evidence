package eu.qwsome.svj.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.TextField;

import java.util.UUID;

/**
 * @author Lukáš Kvídera
 */
public class OwnersController {
  @FXML
  private Menu ownersMenuButton;

  @FXML
  private Menu flatsMenuButton;

  @FXML
  private Button test;

  @FXML
  private ListView<String> ownersList;
  private ObservableList<String> owners;

  @FXML
  private TextField ownerNameField;

  @FXML
  public void initialize() {
    this.owners = FXCollections.observableArrayList();
    this.ownersList.setItems(this.owners);
    this.ownersList.setOnMouseClicked(
      event -> this.ownerNameField.setText(this.ownersList.getSelectionModel().getSelectedItem())
    );
  }

  @FXML
  public void onOwnersButtonClicked() {
    this.owners.add(UUID.randomUUID().toString());
  }
}
