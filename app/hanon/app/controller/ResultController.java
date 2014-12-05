package hanon.app.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import hanon.app.MainDriver;
import hanon.app.model.analyst.dynamics.SoundLevels;
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
	@FXML Label totalPercent;
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
		int[] gbn = this.result.getGBN();
		
		int totalNotes = Arrays.stream(gbn).sum();
		float gp = ((float) gbn[0]);
		goodPercent.setText("" + (int)gp);
		float bp = ((float) gbn[1]);
		badPercent.setText("" + (int)bp);
		float up = ((float) gbn[2]);
		unplayedPercent.setText("" + (int)up);
		if(mainDriver.getPrevious() == null) {
			comparedTo.setText("This is your first playthrough this session");
		} else {
			Integer previous = mainDriver.getPrevious();
			float difference = ((float) gp/totalNotes * 100) - previous;
			String bOrW;
			if(difference < 0) {
				bOrW = "Worse";
			} else {
				bOrW = "Better";
			}
			comparedTo.setText("You did " + Math.round(Math.abs((difference))) + "% " + bOrW + " than last time");
		}
		mainDriver.setPrevious( (int)((((float)gp) / totalNotes)*100));
		
		medal.setImage(result.medalEarned().getMedalImage().getImage());
		totalPercent.setText(Math.round(((float) gp / totalNotes * 100)) + "%");
		
		createPieChart(gbn);
	}

	private void createPieChart(int[] gbn) {
		ObservableList<PieChart.Data> pChartData = 
				FXCollections.observableArrayList(
				new PieChart.Data("Good", gbn[0]),
				new PieChart.Data("Bad", gbn[1]),
				new PieChart.Data("Unplayed", gbn[2]));
		pchart.setData(pChartData);
	}

	@FXML
	public void viewSong() {
		mainDriver.getHPane().setPinnedSide(Side.BOTTOM);
	}
	
	@FXML
	public void playAgain() {
		mainDriver.redraw();
		mainDriver.getHPane().setLeft(null);
		mainDriver.getHPane().setPinnedSide(Side.BOTTOM);
		
		mainDriver.getRootLayoutController().getEvaluationController().handlePlay();
	}
}
