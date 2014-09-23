package hanon.app;


import hanon.app.model.music.MusicNote;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.TimeSignature;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.model.music.GeneralStaffElement.measureLine;
import static hanon.app.model.music.NoteLength.*;
import static hanon.app.model.music.NoteValue.NoteName.*;
import static hanon.app.model.music.NoteValue.fromNameAndOctave;

public class TwinkleTwinkleLittleStar {
  public static final List<StaffElement> elements = new ArrayList<StaffElement>();
  static {
    elements.add(new TimeSignature(2, 4));
    elements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(G, 4), HALF));
    elements.add(measureLine());

    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(C, 4), HALF));
    elements.add(measureLine());

    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(D, 4), HALF));
    elements.add(measureLine());

    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(D, 4), HALF));
    elements.add(measureLine());

    elements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(C, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(G, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(A, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(G, 4), HALF));
    elements.add(measureLine());

    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(F, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(E, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    elements.add(new MusicNote(fromNameAndOctave(D, 4), QUARTER));
    elements.add(measureLine());
    elements.add(new MusicNote(fromNameAndOctave(C, 4), HALF));
    elements.add(measureLine());
  }
}
