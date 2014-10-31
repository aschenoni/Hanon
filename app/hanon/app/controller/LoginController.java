package hanon.app.controller;

import java.io.IOException;

import org.json.simple.JSONArray;

import hanon.app.MainDriver;
import hanon.app.controller.connector.ServerAPI;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class LoginController implements EventHandler{
	
	private MainDriver mainDriver;
	private boolean isPinned;
	
	@FXML public TextField username;
	@FXML public PasswordField password;
	@FXML public Button closeButton;
	
	@FXML public void handleLogin() throws IOException {
		String user = username.getText();
		String pw = password.getText();
		password.clear();
		if(isValidFormat(user, pw))
		{
			JSONArray userProfile = ServerAPI.login(user, pw);
			FXMLLoader loader = BaseController.buildLoader("Profile");
			AnchorPane profile = loader.load();
			mainDriver.getHPane().setRight(profile);
		}
		else
		{
			//TODO Add failure notification
		}
	}
	
	private boolean isValidFormat(String user, String pw) {
		
		//ADD validation rules here
		if(user.length() >= 5 && pw.length() >= 5)
		{
			return true;
		}
		
		return false;
	}

	@FXML public void pin() {
		mainDriver.getHPane().setPinnedSide(Side.RIGHT);
		isPinned = true;
	}
	
	@FXML public void unPin() {
			mainDriver.getHPane().setPinnedSide(null);
			isPinned = false;
	}

	@FXML public void closePressed() {
		closeButton.setStyle("-fx-background-color: rgba(0,0,255,.25);");
	}
	
	@FXML public void closeReleased() {
		closeButton.setStyle("-fx-background-color: rgba(0,0,255,0);");
	}
	
	public void setMainDriver(MainDriver mainDriver) {
		this.mainDriver = mainDriver;
	}

	@Override
	public void handle(Event arg0) {
		unPin();
		
  }
}
