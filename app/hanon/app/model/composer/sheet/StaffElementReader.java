package hanon.app.model.composer.sheet;

import hanon.app.model.music.*;
import hanon.app.model.music.NoteValue.NoteName;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StaffElementReader{
	
	public static StaffElementSet loadFromFile(File file)
	{
		JSONArray json = null;
		JSONParser parser = new JSONParser();
		try {
			
			Object fileIn = parser.parse(new FileReader(file));
			json = (JSONArray) fileIn;
			
			return unMarshall(json);
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	private static StaffElementSet unMarshall(JSONArray json) {
		List<StaffElement> staffElements = new ArrayList<StaffElement>();
		StaffElementSet ste = null;
		Clef clef = null;
		for(Object obj: json){
			JSONObject jsonObj = (JSONObject) obj;
			
			if(jsonObj.containsKey("Clef")){
				clef = Clef.valueOf((String) jsonObj.get("Clef"));
			}
			else if(jsonObj.containsKey("General Element")) {
				if(jsonObj.containsValue("MEASURE_LINE")){
					staffElements.add(GeneralStaffElement.measureLine());
				}
			}
			else if (jsonObj.containsKey("NoteLength")) {
				NoteLength length = NoteLength.valueOf((String) jsonObj.get("NoteLength"));
				String note = (String) jsonObj.get("NoteValue");
				NoteName noteName = NoteValue.NoteName.valueOf(note.substring(0, 1));
				Integer octave = new Integer(note.substring(1));
				
				NoteValue value = NoteValue.fromNameAndOctave(noteName, octave);
				MusicNote noteOut = new MusicNote(value, length);
				
				staffElements.add(noteOut);
			}
			
		  ste = new StaffElementSet(clef,staffElements);
		}
		return ste;
	}

}
