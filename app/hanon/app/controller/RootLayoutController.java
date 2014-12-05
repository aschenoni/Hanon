package hanon.app.controller;


import hanon.app.MainDriver;
import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.composer.StaffElementWriter;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.player.sheet.MusicSheet;

import java.io.File;
import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

public class RootLayoutController extends BaseController {
	
	//Allows for communication with other parts of the application
	private MainDriver mainDriver;
  private MusicSheet sheet;
  private EvaluationController evalController;
  
	public void setMainDriver(MainDriver mainDriver){
		this.mainDriver = mainDriver;
	}
	
	@FXML
	private void handleOpen(){
		
		//Create fileChooser for user to pick file to load
		FileChooser fileChooser = new FileChooser();
		fileChooser.setInitialDirectory(new File("musicLibrary"));
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HANON files (*.hanon)", "*.hanon");
		fileChooser.getExtensionFilters().add(extFilter);
		
		File file = fileChooser.showOpenDialog(mainDriver.getPrimaryStage());
		
		//Hitting cancel returns a null file so...
		if(file != null) {
			StaffElementSet set = StaffElementReader.loadFromFile(file);
			sheet = new MusicSheet(set);
      sheet.setup(500, 500);
      sheet.draw();
			mainDriver.getRootLayout().setCenter(sheet);
		}
		
		Node currentSheet = mainDriver.getRootLayout().getCenter();
		if(currentSheet instanceof MusicSheet){
			FXMLLoader loader = buildLoader("Rhythm");
			AnchorPane rhythmPane;
			try {
				rhythmPane = loader.load();
				EvaluationController evaluationController = loader.getController();
				mainDriver.getHPane().setBottom(rhythmPane);
				mainDriver.getHPane().setPinnedSide(Side.BOTTOM);
				evaluationController.setMainDriver(mainDriver);
				evaluationController.setSheet(sheet);
				this.evalController = evaluationController;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@FXML
	private void handleSave(){
		//TODO: Once the getPath and setPath methods are instantiated for the default;
		handleSaveAs();
	}
	
	@FXML
	private void handleSaveAs(){
		Node currentSheet = mainDriver.getRootLayout().getCenter();
		
		if(currentSheet instanceof MusicSheet){
			StaffElementSet set = ((MusicSheet) currentSheet).getSets().get(0);
			
			FileChooser fileChooser = new FileChooser();
			FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Hanon files (*.hanon)", "*.hanon");
			fileChooser.setInitialDirectory(new File("musicLibrary"));
			fileChooser.getExtensionFilters().add(extFilter);
			File file = fileChooser.showSaveDialog(mainDriver.getPrimaryStage());
			
			if(file != null) {
				//ensure the extension is correct
				if(!file.getPath().endsWith(".hanon")){
					file = new File(file.getPath() + ".hanon");
				}
				StaffElementWriter.saveToFile(file, set);
			}
			
		}
	}
	
	@FXML private void handleTuner() throws InterruptedException, IOException{
    TunerController controller = (TunerController)BaseController.loadWindowFromTitle("Tuner");
    controller.handleTuner();
  }
	
	@FXML private void handleClicker() throws IOException {
		if(mainDriver.getRootLayout().getCenter() instanceof MusicSheet) {
		
			ObservableList<StaffElementSet> sets = ((MusicSheet)mainDriver.getRootLayout().getCenter()).getSets();
			StaffElementSet set = sets.get(0);
			evalController.handleRhythm(set.getElements());
			}
		}

  @FXML
	private void handleAbout(){
		System.out.println("HELLO");
	}
	
	@FXML
	private void handleExit(){
		//TODO
	}
}
