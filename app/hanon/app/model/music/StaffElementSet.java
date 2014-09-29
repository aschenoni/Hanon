package hanon.app.model.music;

import hanon.app.model.music.jsonutil.JSONUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StaffElementSet {
  private Clef clef;
  private final List<StaffElement> elements;

  public static StaffElementSet fromJSON(JSONArray array) {
    List<StaffElement> staffElements = new ArrayList<StaffElement>();
    Clef clef = null;
    for(Object obj: array){
      JSONObject jsonObj = (JSONObject) obj;
      if(jsonObj.containsKey("Clef"))
        clef = Clef.valueOf((String) jsonObj.get("Clef"));
      else if(jsonObj.containsKey("General Element"))
        staffElements.add(GeneralStaffElement.fromJSON(jsonObj));
      else if (jsonObj.containsKey("NoteLength"))
        staffElements.add(MusicNote.noteFromJSON(jsonObj));
    }
    StaffElementSet set = new StaffElementSet(clef, staffElements);
    return set;
  }

  public StaffElementSet(Clef clef, List<StaffElement> elements) {
    this.clef = clef;
    this.elements = elements;
  }

  public List<StaffElement> getElements() {
    return elements;
  }

  public Clef getClef() {
    return clef;  
  }
  
  public JSONArray toJSON(){
	  JSONArray array = new JSONArray();

    array.add(JSONUtil.stringsToJSON("Clef", clef.toString()));
	  for(StaffElement element: elements){
		  array.add(element.toJSON());
	  }
	  return array;
  }
}

