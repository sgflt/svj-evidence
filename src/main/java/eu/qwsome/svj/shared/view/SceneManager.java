package eu.qwsome.svj.shared.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.EnumMap;

/**
 * @author Lukáš Kvídera
 */
@Controller
public class SceneManager {

  private final EnumMap<View, URL> viewMapping = new EnumMap<>(View.class);
  private final ApplicationContext context;

  public SceneManager(final ApplicationContext context) {
    this.context = context;
    this.viewMapping.put(View.MAIN, SceneManager.class.getResource("/mainPage.fxml"));
    this.viewMapping.put(View.FLAT_OWNER_EDIT, SceneManager.class.getResource("/flatOwnerEdit.fxml"));
    this.viewMapping.put(View.FLAT_CREATE, SceneManager.class.getResource("/flatCreate.fxml"));
    this.viewMapping.put(View.ADDRESS_CREATE, SceneManager.class.getResource("/addressCreate.fxml"));
  }

  public void switchTo(final View view, final Scene scene) {
    final URL url = this.viewMapping.get(view);
    final FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setLocation(url);
    fxmlLoader.setControllerFactory(this.context::getBean);

    final Parent parent;
    try {
      parent = fxmlLoader.load();
    } catch (final IOException e) {
      throw new IllegalStateException("Cannot load scene!");
    }
    scene.setRoot(parent);
  }
}
