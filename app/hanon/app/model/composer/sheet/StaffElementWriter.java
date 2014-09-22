package hanon.app.model.composer.sheet;

import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;

import java.io.File;

public class StaffElementWriter{

	static public void saveToFile(File file, StaffElementSet staffElements) {
		try {
			for(StaffElement element: staffElements.getElements())
			{
				
			}
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
