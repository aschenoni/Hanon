package hanon.app;

import hanon.app.controller.BaseController;
import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.controller.RootLayoutController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;


public class MainDriver extends Application {

	private Stage primaryStage;
  private BorderPane rootLayout; //Main application node from which everything will be a child

  /**
	 * JavaFX application main method
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
		
		initPrimaryScene();
  }
	
	/**
	 * Adds rootLayout and music view to window
	 * and attaches controllers to the main driver
	 */
	private void initPrimaryScene() {
		try {
      FXMLLoader loader = BaseController.buildLoader("RootLayout");
			rootLayout = loader.load();
      buildController(loader);
      buildScene();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

  private void buildController(FXMLLoader loader) {
    RootLayoutController controller = loader.getController();
    controller.setMainDriver(this);
  }

  private void buildScene() {
    Scene scene = new Scene(rootLayout);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public Window getPrimaryStage() {
		return this.primaryStage;
	}

	public void loadSheetMusic(File file) {
		StaffElementSet set  = StaffElementReader.loadFromFile(file);
		MusicSheet sheet = new MusicSheet(set);
		sheet.draw(500, 500);
		rootLayout.setCenter(sheet);
	}

	public BorderPane getRootLayout(){
		return this.rootLayout;
	}

	public static void main(String[] args) {
		launch(args);
	}
}