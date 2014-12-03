package hanon.app.model.music;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class StaffElementSet {
  public static StaffElementSet fromJSON(JSONArray array) {
    List<StaffElement> staffElements = new ArrayList<>();
    for(Object obj: array)
      staffElements.add(elementFromJSON((JSONObject) obj));
    return new StaffElementSet(staffElements);
  }

  private static StaffElement elementFromJSON(JSONObject jsonObj) {
    if(jsonObj.containsKey("Clef"))
      return Clef.valueOf((String) jsonObj.get("Clef"));
    else if (jsonObj.containsKey("General Element"))
      return GeneralStaffElement.fromJSON(jsonObj);
    else if (jsonObj.containsKey("Slur"))
      return Slur.fromJSON(jsonObj);
    else if (jsonObj.containsKey("NoteLength"))
      return MusicNote.fromJSON(jsonObj);
    else if (jsonObj.containsKey("TimeSignature"))
      return TimeSignature.fromJSON(jsonObj);
    else if (jsonObj.containsKey("Crescendo"))
      return Crescendo.fromJSON(jsonObj);
    else if (jsonObj.containsKey("Decrescendo"))
      return Decrescendo.fromJSON(jsonObj);
    else
      throw new RuntimeException("No such StaffElement: " + jsonObj.toString());
  }

  private final List<StaffElement> elements;

  public StaffElementSet(List<StaffElement> elements) {
    this.elements = elements;
  }

  public List<StaffElement> getElements() {
    return elements;
  }

  public Clef getClef() {
    for (StaffElement e : elements)
      if (e.getType() == StaffElementType.CLEF)
        return (Clef) e;
    throw new RuntimeException("StaffSet has no clef");
  }
  
  public JSONArray toJSON(){
	  JSONArray array = new JSONArray();
	  for(StaffElement element: elements)
		  array.add(element.toJSON());
	  return array;
  }
}

