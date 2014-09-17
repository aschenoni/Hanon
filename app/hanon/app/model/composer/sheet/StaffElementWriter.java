package hanon.app.model.composer.sheet;

import hanon.app.model.music.StaffElementSet;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class StaffElementWriter{

	void saveToFile(File file, StaffElementSet staffElements) {
		try {
			JAXBContext context = JAXBContext.newInstance(StaffElementSet.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			m.marshal(staffElements, file);
		}
		catch (Exception e) {
			System.out.println("Unable to save StaffElements as an XML File");
		}
	}
}
