package hanon.app.model.composer.sheet;

import hanon.app.model.music.StaffElementSet;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class StaffElementReader{
	
	StaffElementSet loadFromFile(File file)
	{
		StaffElementSet wrapper = null;
		try {
			JAXBContext context = JAXBContext.newInstance(StaffElementSet.class);
			Unmarshaller um = context.createUnmarshaller();
			
			wrapper = (StaffElementSet) um.unmarshal(file);
		}
		catch (Exception e){
			System.out.println("Could not load data from file");			
		}
		return wrapper;
	}

}
