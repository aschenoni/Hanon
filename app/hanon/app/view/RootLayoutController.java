package hanon.app.view;


import hanon.app.MainDriver;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;

public class RootLayoutController {
	
	//Allows for communication with other parts of the application
	private MainDriver mainDriver;
	
	public void setMainDriver(MainDriver mainDriver){
		this.mainDriver = mainDriver;
	}
	
	@FXML
	private void handleOpen(){
		
		//Create fileChooser for user to pick file to load
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("HANON files (*.hanon)", "*.hanon");
		fileChooser.getExtensionFilters().add(extFilter);
		
		File file = fileChooser.showOpenDialog(mainDriver.getPrimaryStage());
		
			mainDriver.loadSheetMusic(file);

	}
	
	@FXML
	private void handleSave(){
		
	}
	
	@FXML
	private void handleSaveAs(){
		
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
