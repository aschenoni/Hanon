package hanon.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import hanon.app.model.composer.sheet.StaffElementReader;
import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElementSet;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import hanon.app.model.player.sheet.MusicSheet;
import static hanon.app.TwinkleTwinkleLittleStar.*;


public class MainDriver extends Application{

	private Stage primaryStage;
	
	private BorderPane rootLayout; //Main application node from which everything will be a child
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
		
		initRootLayout();
		
		drawTwinkleTwinkleLittleStar();
	}

	private void initRootLayout() {
		try{
			// Load the root layout from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	private void drawTwinkleTwinkleLittleStar() {

    List<StaffElementSet> sets = new ArrayList<StaffElementSet>();
    sets.add(StaffElementReader.loadFromFile(new File("musicLibrary/twinkletwinkle.hanon")));

		MusicSheet twinkleMusic = new MusicSheet(FXCollections.observableArrayList(sets));
		rootLayout.setCenter(twinkleMusic);
		twinkleMusic.draw(500, 500); //500 is a temporary arbitrary less than 800x600 size (800x600 is main window pref size)
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
