package recorder;

import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;
import hanon.app.view.TwinkleTwinkleLittleStar;

import java.util.List;

public class JSONTest {

	public static void main(String[] args) {
		List<StaffElement> ttls = TwinkleTwinkleLittleStar.elements;
		
		for(StaffElement element: ttls){
			System.out.println(element.toJSON().toString());
		}
		
		StaffElementSet ste = new StaffElementSet(Clef.TREBLE, ttls);
		System.out.println(ste.toJSON());
	}
	

}
