package hanon.app.musicpiece;

import hanon.app.model.music.*;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.NoteValue.fromNameAndOctave;

public class CMajorScale {
  public static final List<StaffElement> elements = new ArrayList<StaffElement>();
  static {
    elements.add(Clef.TREBLE);

    elements.add(new TimeSignature(4, 4));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.F, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.G, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 5), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.B, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.A, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.G, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());

    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.F, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.E, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.D, 4), NoteLength.QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(NoteValue.NoteName.C, 4), NoteLength.QUARTER));
    elements.add(GeneralStaffElement.measureLine());
  }

}
