package hanon.app;

import hanon.app.controller.BaseController;
import hanon.app.controller.LoginController;
import hanon.app.controller.ResultController;
import hanon.app.controller.RootLayoutController;
import hanon.app.model.analyst.results.SongResult;
import hanon.app.model.player.sheet.MusicSheet;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

import org.controlsfx.control.HiddenSidesPane;


public class MainDriver extends Application {

  private static MainDriver instance;

  public static MainDriver getInstance() {
    return instance;
  }

	private Stage primaryStage;
	private BorderPane rootLayout; //Main application node from which everything will be a child
	private HiddenSidesPane hPane;
	private Integer previousSongPercent;
	
  	/**
	 * JavaFX application main method
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
    instance = this;
		
		initPrimaryScene();
  }
	
	/**
	 * Adds rootLayout and music view to window
	 * and attaches controllers to the main driver
	 */
	private void initPrimaryScene() {
		try {
	  
	    //Add hPane as top layer to allow for hidden sides on RootLayout
	    hPane = new HiddenSidesPane();

	  
      FXMLLoader loader = BaseController.buildLoader("RootLayout");
			rootLayout = loader.load();
      buildController(loader);
	    addLoginSideBar(hPane);

      buildScene();
      
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void redraw(){
		if(rootLayout.getCenter() instanceof MusicSheet) {
			((MusicSheet) rootLayout.getCenter()).draw();
		}
	}
	private void addLoginSideBar(HiddenSidesPane hPane2) throws IOException {
		FXMLLoader loader = BaseController.buildLoader("Login");
	  hPane.setContent(rootLayout);
		AnchorPane rightA = loader.load();
		LoginController controller = loader.getController();
		controller.setMainDriver(this);
	  hPane.setRight(rightA);
	  hPane.getContent().setOnMouseClicked(new EventHandler<MouseEvent>() {
	    	public void handle(MouseEvent me) {
	    		controller.unPin();
	    	}
	    });
	}

	/**
	 * attaches controllers to the MainDriver
	 * @param loader
	 */
  private void buildController(FXMLLoader loader) {
    RootLayoutController controller = loader.getController();
    controller.setMainDriver(this);
  }

  /**
   * Builds and presents the Base of the Application to the user
   */
  private void buildScene() {
    Scene scene = new Scene(hPane);
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public Window getPrimaryStage() {
		return this.primaryStage;
	}

  /**
   * Gives other controllers permission to edit the main window
   * @return
   */
	public BorderPane getRootLayout(){
		return this.rootLayout;
	}

	public HiddenSidesPane getHPane(){
		return this.hPane;
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	public void showResults(SongResult sr) {
		FXMLLoader loader = BaseController.buildLoader("Result");
		try {
			AnchorPane resultPane = loader.load();
			ResultController controller = loader.getController();
			controller.setMainDriver(this);
			controller.setSongResult(sr);
			hPane.setLeft(resultPane);
			hPane.setPinnedSide(Side.LEFT);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Integer getPrevious() {
		return previousSongPercent;
	}

	public void setPrevious(Integer integer) {
		this.previousSongPercent = integer;
		
	}
}