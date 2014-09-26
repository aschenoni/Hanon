package sheet;

import hanon.app.model.composer.StaffElementWriter;
import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;
import hanon.app.view.CMajorScale;

import java.io.File;
import java.util.List;

public class TestStaffElementWriter {

	public static void main(String[] args)
	{
		File file = new File("musicLibrary/cmajorscale.hanon");
		List<StaffElement> newList = CMajorScale.elements;
		StaffElementSet ste = new StaffElementSet(Clef.TREBLE,newList);
		
		StaffElementWriter.saveToFile(file, ste);
		

	}
}
