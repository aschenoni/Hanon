package hanon.app.model.music.jsonutil;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JSONUtil {

  /**
   * Return a JSON Object from the given string values.
   * There should be an even number of string values passed. Will create a
   * mapping
   *
   * values[0] -> values[1],
   * values[2] -> values[3],
   * ...
   * values[n-1] -> values[n]
   */
  public static JSONObject stringsToJSON(String... values) {
    Map<String, String> map = new HashMap<>();
    for (int i = 0; i < values.length; i+=2) {
      map.put(values[i], values[i+1]);
    }
    return new JSONObject(map);
  }
}
