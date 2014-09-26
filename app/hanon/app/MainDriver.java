package hanon.app;

import hanon.app.model.analyst.tuner.Tuner;
import hanon.app.model.analyst.tuner.TunerObserver;
import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.view.RootLayoutController;
import hanon.app.view.TunerController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;


public class MainDriver extends Application{

	private Stage primaryStage;
	
	private TunerController tunerController;
	private BorderPane rootLayout; //Main application node from which everything will be a child
	private AnchorPane musicView;
	
	/**
	 * JavaFX application main method
	 */
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
		
		initPrimaryScene();

    //loadSheetMusic(new File("musicLibrary/twinkletwinkle.hanon"));
  }
	
	/**
	 * Adds rootLayout and music view to window
	 * and attaches controllers to the main driver
	 */
	private void initPrimaryScene() {
		try {
			// Load the root layout view from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			// Link rootLayoutController to the main app
			RootLayoutController controller = loader.getController();
			controller.setMainDriver(this);
			
			// Load MusicView
			loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/MusicView.fxml"));
			this.musicView = (AnchorPane) loader.load();
			
			// Draw the scene and show it
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// Draw music view in the center
			//rootLayout.setCenter(musicView);
			

		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * called when the tuner window is requested
	 * @throws InterruptedException 
	 * @throws IOException 
	 */
	public void initTuner() throws InterruptedException, IOException {
		Stage tunerStage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainDriver.class.getResource("view/Tuner.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		TunerController tunerController = loader.getController();
		//tunerController.setMainDriver();
		this.tunerController=tunerController;
		tunerStage.setTitle("Tuner");
		tunerStage.initModality(Modality.WINDOW_MODAL);
		tunerStage.initOwner(primaryStage);
		Scene scene = new Scene(page);
		tunerStage.setScene(scene);
		tunerController.handleTuner();
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
	/*
	 * Main method, consists only of launch as
	 * JavaFX handles all application stuff within launch
	 */
	public static void main(String[] args) {
		launch(args);
	}

	public TunerObserver getTunerController() {
		
		return this.tunerController;
	}



}
