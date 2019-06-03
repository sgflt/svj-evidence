package eu.qwsome.svj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Lukáš Kvídera
 */
@SpringBootApplication
public class Main extends Application {

  private static final Logger LOG = LoggerFactory.getLogger(Main.class);

  private ConfigurableApplicationContext springContext;

  @Override
  public void init() {
    LOG.trace("init()");
    this.springContext = SpringApplication.run(Main.class);
  }

  @Override
  public void start(final Stage primaryStage) throws Exception {
    LOG.trace("start(Stage)");
    final FXMLLoader fxmlLoader = new FXMLLoader();
    fxmlLoader.setControllerFactory(this.springContext::getBean);
    fxmlLoader.setLocation(getClass().getResource("/mainPage.fxml"));
    final Parent root = fxmlLoader.load();
    primaryStage.setTitle("SVJ Evidence");
    primaryStage.setScene(new Scene(root, 1024, 800));
    primaryStage.show();
  }

  @Override
  public void stop() {
    this.springContext.stop();
  }

  public static void main(final String[] args) {
    launch(args);
  }
}
