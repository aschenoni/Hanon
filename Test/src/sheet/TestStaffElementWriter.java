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
		File file = new File("..");
		List<StaffElement> newList = twinkleElements();
		StaffElementSet ste = new StaffElementSet(Clef.TREBLE,newList);
		
		StaffElementWriter.saveToFile(file, ste);
		

	}

	private static List<StaffElement> twinkleElements() {
		 final List<StaffElement> elements = new ArrayList<StaffElement>();

		    elements.add(new TimeSignature(2, 4));
		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), HALF));
		    elements.add(measureLine());

		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), HALF));
		    elements.add(measureLine());

		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), HALF));
		    elements.add(measureLine());

		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), HALF));
		    elements.add(measureLine());

		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(A, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(G, 4), HALF));
		    elements.add(measureLine());

		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(F, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(E, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
		    elements.add(new WrittenNote(fromNameAndOctave(D, 4), QUARTER));
		    elements.add(measureLine());
		    elements.add(new WrittenNote(fromNameAndOctave(C, 4), HALF));
		    elements.add(measureLine());
		  
		  
		  return elements;
	}
}
