package hanon.app.model.achiever;

import java.io.File;

import org.json.simple.JSONObject;

import javafx.scene.image.Image;

public class Achievement {

	private int ID;
	private String title;
	private String description;
	private Image icon;
	
	public Achievement(int ID, String title, String description, File icon)
	{
		this.ID = ID;
		this.title = title;
		this.description = description;
		this.icon = new Image(icon.toURI().toString(), 75, 75, true, true, true);
	}
	
	@Override
	public String toString()
	{
		return "ID: " + ID + "\nTitle: " + title + "\nDescription: " + description;
	}
}
