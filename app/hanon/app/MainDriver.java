package hanon.app;

import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.sheet.MusicSheet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class MainDriver extends Application{

	private Stage primaryStage;
	
	private BorderPane rootLayout; //Main application node from which everything will be a child
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
		
		initRootLayout();

    loadSheetMusic(new File("musicLibrary/twinkletwinkle.hanon"));
  }

	private void initRootLayout() {
		try {
			// Load the root layout from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/MusicView.fxml"));
			AnchorPane musicView = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
			rootLayout.setCenter(musicView);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

  public static void main(String[] args) {
		launch(args);
	}

	public Window getPrimaryStage() {
		return this.primaryStage;
	}

	public void loadSheetMusic(File file) {
		StaffElementSet set  = StaffElementReader.loadFromFile(file);
		ArrayList<StaffElementSet> list = new ArrayList<StaffElementSet>();
    list.add(set);
		
		MusicSheet sheet = new MusicSheet(FXCollections.observableArrayList(list));
		rootLayout.setCenter(sheet);
		sheet.draw(500, 500);
	}
}
