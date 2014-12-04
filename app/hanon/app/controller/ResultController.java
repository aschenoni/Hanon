package hanon.app.controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import hanon.app.MainDriver;
import hanon.app.model.analyst.results.SongResult;

public class ResultController extends BaseController {

	private MainDriver mainDriver;
	private SongResult result;
	
	/*****FXML OBJECTS******/
	@FXML Label resultTitle;
	@FXML Label comparedTo;
	@FXML Label goodPercent;
	@FXML Label badPercent;
	@FXML Label unplayedPercent;
	@FXML PieChart pchart;
	@FXML ImageView profile;
	@FXML ImageView medal;
	@FXML BarChart level;
	
	public ResultController() {
		
	}
	
	public void setMainDriver(MainDriver mainDriver) {
		this.mainDriver = mainDriver;
	}
	
	public void setSongResult(SongResult result) {
		this.result = result;
	}
	
	@FXML
	public void viewSong() {
		mainDriver.getHPane().setPinnedSide(null);
	}
	
	@FXML
	public void playAgain() {
		mainDriver.redraw();
		mainDriver.getHPane().setPinnedSide(Side.BOTTOM);
		mainDriver.getHPane().setLeft(null);
	}
}
