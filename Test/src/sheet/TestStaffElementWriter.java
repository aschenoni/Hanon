package sheet;

import hanon.app.TwinkleTwinkleLittleStar;
import hanon.app.model.composer.sheet.StaffElementWriter;
import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;

import java.io.File;
import java.util.List;

public class TestStaffElementWriter {

	public static void main(String[] args)
	{
		File file = new File("musicLibrary/twinkletwinkle.hanon");
		List<StaffElement> newList = TwinkleTwinkleLittleStar.elements;
		StaffElementSet ste = new StaffElementSet(Clef.TREBLE,newList);
		
		StaffElementWriter.saveToFile(file, ste);
		

	}
}
