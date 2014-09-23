package hanon.app.controller;

import java.io.File;

import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import hanon.app.MainDriver;

public class RootLayoutController {
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
		
		if(file != null){
			mainDriver.loadSheetMusic(file);
		}
	}
}
