package hanon.app;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainDriver extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hanon");
		Button btn = new Button();
		btn.setText("Click!");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello!");
			}
		});
		
		VBox root = new VBox();
		
		MenuBar menuBar = new MenuBar();
		Menu menuFile = new Menu("File");
		Menu menuEdit = new Menu("Edit");
		Menu menuView = new Menu("View");
		Menu menuHelp = new Menu("Help");
		menuBar.getMenus().addAll(menuFile, menuEdit, menuView);
		
		Label label = new Label("Welcome to Hanon!");
		
		root.getChildren().addAll(menuBar);
		root.getChildren().add(label);
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, 800, 600) );
		
		

		
		

		primaryStage.show();
	}
}
