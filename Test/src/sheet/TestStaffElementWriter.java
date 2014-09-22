package sheet;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.NoteLength.HALF;
import static hanon.app.model.music.NoteLength.QUARTER;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;
import static hanon.app.model.music.NoteValue.NoteName.A;
import static hanon.app.model.music.NoteValue.NoteName.C;
import static hanon.app.model.music.NoteValue.NoteName.D;
import static hanon.app.model.music.NoteValue.NoteName.E;
import static hanon.app.model.music.NoteValue.NoteName.F;
import static hanon.app.model.music.NoteValue.NoteName.G;
import hanon.app.TwinkleTwinkleLittleStar;
import hanon.app.model.composer.record.WrittenNote;
import hanon.app.model.composer.sheet.StaffElementWriter;
import hanon.app.model.music.Clef;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.StaffElementSet;
import hanon.app.model.music.TimeSignature;

import java.io.File;
import java.util.ArrayList;
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
