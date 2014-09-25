package sheet;

import hanon.app.model.composer.StaffElementReader;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;
import hanon.app.view.TwinkleTwinkleLittleStar;

import java.io.File;
import java.util.List;

public class TestStaffElementReader {

	public static void main(String[] args) {
		File file = new File("musicLibrary/twinkletwinkle.hanon");
		List<StaffElement> newList = TwinkleTwinkleLittleStar.elements;
		
		StaffElementSet set = StaffElementReader.loadFromFile(file);

	}

}
