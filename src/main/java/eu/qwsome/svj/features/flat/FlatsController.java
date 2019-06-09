package eu.qwsome.svj.features.flat;

import eu.qwsome.svj.features.ownership.OwnershipController;
import eu.qwsome.svj.shared.view.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


/**
 * @author Lukáš Kvídera
 */
@Controller
public class FlatsController {

  private static final Logger LOG = LoggerFactory.getLogger(FlatsController.class);

  private final FlatService flatService;
  private final SceneManager sceneManager;
  private final OwnershipController ownershipController;

  @FXML
  private ListView<Flat> flatList;

  @Autowired
  public FlatsController(
    final FlatService flatService,
    final OwnershipController ownershipController,
    final SceneManager sceneManager
  ) {
    this.flatService = flatService;
    this.ownershipController = ownershipController;
    this.sceneManager = sceneManager;
  }

  @FXML
  public void initialize() {
    LOG.trace("initialize()");
    this.flatList.setItems(this.flatService.findAll());
    this.flatList.setCellFactory(listView ->
      new ListCell<>() {
        @Override
        public void updateItem(final Flat item, final boolean empty) {
          LOG.debug("updateItem(item={}, empty={}", item, empty);
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
      this.ownershipController.displayOwnershipFor(id);
    });

  }
}
