package hanon.app.controller;

import hanon.app.MainDriver;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public abstract class BaseController {
  static BaseController loadFromTitle(String title) throws IOException {
    FXMLLoader loader = buildLoader(title);
    Stage stage = buildStage(title, loader);
    return buildController(loader, stage);
  }

  public static FXMLLoader buildLoader(String title) {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(MainDriver.class.getResource("view/" + title + ".fxml"));
    return loader;
  }

  private static Stage buildStage(String title, FXMLLoader loader) throws IOException {
    Stage stage = new Stage();
    stage.setTitle(title);
    stage.setScene(new Scene(loader.<Pane>load()));
    stage.show();
    return stage;
  }

  private static BaseController buildController(FXMLLoader loader, Stage stage) {
    BaseController controller = loader.getController();
    controller.setStage(stage);
    return controller;
  }



  private Stage stage;

  void setStage(Stage stage) {
    this.stage = stage;
    this.stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
      @Override
      public void handle(WindowEvent windowEvent) {
        stop();
      }
    });
  }

  void stop() {
    stage.close();
  }
}
