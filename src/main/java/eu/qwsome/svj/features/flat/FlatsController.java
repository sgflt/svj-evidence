package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.shared.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class FlatsController {

  private final FlatService flatService;
  private final SceneManager sceneManager;

  @FXML
  private ListView<Flat> flatList;
  @FXML
  private TextArea flatDetail;

  @Autowired
  public FlatsController(final FlatService flatService, final SceneManager sceneManager) {
    this.flatService = flatService;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void initialize() {
    this.flatList.setItems(this.flatService.findAll());
    this.flatList.setCellFactory(listView ->
      new ListCell<>() {
        @Override
        public void updateItem(final Flat item, final boolean empty) {
          super.updateItem(item, empty);
          if (item == null) {
            setText(null);
          } else {
            setText(item.getAddress());
          }
        }
      });
    this.flatList.setOnMouseClicked(event -> {
      final int id = this.flatList.getSelectionModel().getSelectedItem().getId();
      this.flatDetail.setText(this.flatService.findById(id).toString());
    });
  }
}
