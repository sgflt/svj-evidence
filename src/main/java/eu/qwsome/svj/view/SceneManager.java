package eu.qwsome.svj.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.EnumMap;

/**
 * @author Lukáš Kvídera
 */
public class SceneManager {

  private static final EnumMap<View, Parent> viewMapping = new EnumMap<>(View.class);

  static {
    try {
      viewMapping.put(View.MAIN, FXMLLoader.load(SceneManager.class.getResource("/mainPage.fxml")));
      viewMapping.put(View.FLAT_OWNER_EDIT, FXMLLoader.load(SceneManager.class.getResource("/flatOwnerEdit.fxml")));
    } catch (final IOException e) {
      e.printStackTrace();
    }
  }

  public static void switchTo(final View view, final Scene scene) {
    final Parent parent = viewMapping.get(view);
    scene.setRoot(parent);
  }
}
