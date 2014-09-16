package player;

import hanon.app.model.music.NoteLength;
import hanon.app.model.music.NoteValue;
import hanon.app.model.music.StaffElement;
import hanon.app.model.music.TimeSignature;
import hanon.app.model.player.staff.TimeSignatureImage;
import hanon.app.model.composer.record.WrittenNote;

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
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(A, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(G, 4), half));
    elements.add(measureLine());

    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(F, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(E, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(new WrittenNote(fromNameAndOctave(D, 4), quarter));
    elements.add(measureLine());
    elements.add(new WrittenNote(fromNameAndOctave(C, 4), half));
    elements.add(measureLine());
  }
}
