package hanon.app.model.achiever;

import hanon.app.model.music.jsonutil.JSONReader;

import java.io.File;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AchievementFactory {
	
	public static ArrayList<Achievement> genAchievements(File file)
	{
		ArrayList<Achievement> achievements = new ArrayList();
		JSONArray json = JSONReader.read(file);
		for(Object obj: json)
		{
			JSONObject achieveJSON = (JSONObject) obj;
			Achievement achievement = AchievementFactory.fromJSON(achieveJSON);
		}
		
		return achievements; 
	}
	
	public static Achievement fromJSON(JSONObject json)
	{
		int ID = (int) json.get("ID");
		String title = (String) json.get("title");
		String descr = (String) json.get("description");
		File file = new File((String)json.get("icon"));
		Achievement achievement = new Achievement(ID, title,descr,file);
		return achievement;
	}
}
