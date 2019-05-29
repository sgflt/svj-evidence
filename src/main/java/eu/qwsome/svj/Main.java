package eu.qwsome.svj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Lukáš Kvídera
 */
public class Main extends Application {

  @Override
  public void start(final Stage primaryStage) throws Exception {
    final Parent root = FXMLLoader.load(getClass().getResource("/mainPage.fxml"));
    primaryStage.setTitle("SVJ Evidence");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }


  public static void main(final String[] args) {
    launch(args);
  }
}
