package hanon.app.musicpiece;

import hanon.app.model.music.*;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.NoteValue.*;

public class TwinkleTwinkleLittleStar {
  public static final List<StaffElement> elements = new ArrayList<>();
  static {
    elements.add(Clef.TREBLE);

    elements.add(new TimeSignature(2, 4));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.A, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.A, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.G, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.E, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteName.D, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
    elements.add(new MusicNote(fromNameAndOctave(NoteName.C, 4), NoteLength.HALF));
    elements.add(GeneralStaffElement.measureLine());
  }
}
