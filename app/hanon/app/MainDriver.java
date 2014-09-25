package hanon.app;

import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.sheet.MusicSheet;
import hanon.app.view.RootLayoutController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainDriver extends Application{

	private Stage primaryStage;
	
	private BorderPane rootLayout; //Main application node from which everything will be a child
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Hanon");
		
		initRootLayout();
		
		//drawTwinkleTwinkleLittleStar();
	}

	private void initRootLayout() {
		try{
			// Load the root layout from the fxml file
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/RootLayout.fxml"));


			rootLayout = (BorderPane) loader.load();
			RootLayoutController controller = loader.getController();
			controller.setMainDriver(this);
			System.out.println(controller.toString());
			loader = new FXMLLoader();
			loader.setLocation(MainDriver.class.getResource("view/MusicView.fxml"));
			AnchorPane musicView = (AnchorPane) loader.load();
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();

			rootLayout.setCenter(musicView);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}

	}
	
	private void drawTwinkleTwinkleLittleStar() {

    List<StaffElementSet> sets = new ArrayList<StaffElementSet>();
    sets.add(StaffElementReader.loadFromFile(new File("musicLibrary/twinkletwinkle.hanon")));

    //sets.add(new StaffElementSet(Clef.TREBLE, TwinkleTwinkleLittleStar.elements));

		MusicSheet twinkleMusic = new MusicSheet(FXCollections.observableArrayList(sets));
		rootLayout.setCenter(twinkleMusic);
		twinkleMusic.draw(500, 500); //500 is a temporary arbitrary less than 800x600 size (800x600 is main window pref size)
		
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}

	public Window getPrimaryStage() {
		return this.primaryStage;
	}

	public void loadSheetMusic(File file) {
		StaffElementSet ste  = StaffElementReader.loadFromFile(file);
		List<StaffElementSet> list = new ArrayList<StaffElementSet>();
		list.add(ste);
		MusicSheet sheet = new MusicSheet(FXCollections.observableArrayList(list));
		sheet.draw(500, 500);
		rootLayout.setCenter(sheet);
		
	}
}
