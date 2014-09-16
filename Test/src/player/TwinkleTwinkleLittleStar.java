package player;

import hanon.app.controller.composer.record.WrittenNote;
import hanon.app.controller.music.NoteLength;
import hanon.app.controller.music.NoteValue;
import hanon.app.controller.music.StaffElement;
import hanon.app.controller.music.TimeSignature;
import hanon.app.controller.player.staff.TimeSignatureImage;

import java.util.ArrayList;
import java.util.List;

import static hanon.app.controller.music.GeneralStaffElement.measureLine;
import static hanon.app.controller.music.NoteLength.*;
import static hanon.app.controller.music.NoteValue.NoteName.*;
import static hanon.app.controller.music.NoteValue.fromNameAndOctave;

class TwinkleTwinkleLittleStar {
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
