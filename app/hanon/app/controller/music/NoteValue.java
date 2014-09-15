package hanon.app.controller.music;

import static java.lang.Math.*;

public class NoteValue {
  public enum NoteName {
    C, CSharp,
    D, DSharp,
    E,
    F, FSharp,
    G, GSharp,
    A, ASharp,
    B;

    private static int indexOf(NoteName name) {
      for (int i = 0; i < values().length; i++)
        if (values()[i].equals(name)) return i;
      return -1;
    }

    private static int staffDiff(NoteName name) {
      switch (name) {
        case C: case CSharp: return 4;
        case D: case DSharp: return 5;
        case E:              return 6;
        case F: case FSharp: return 7;
        case G: case GSharp: return 8;
        case A: case ASharp: return 9;
        case B:              return 10;
      }
      return 0;
    }

  }
  public static final float A4 = 440.0f;
  private static final int A_INDEX = NoteName.indexOf(NoteName.A);
  private static final int NUM_HALF_STEPS_IN_OCTAVE = 12;
  private static final float FREQ_CONST = (float) pow(2.0, (1.0 / NUM_HALF_STEPS_IN_OCTAVE));


  public static NoteValue fromNameAndOctave(NoteName name, int octave) {
    int halfStepsFromA = NoteName.indexOf(name) - A_INDEX;
    int octaveHalfSteps = (octave - 4) * 12;
    int halfSteps = halfStepsFromA + octaveHalfSteps;
    return new NoteValue((float) (A4 * Math.pow(FREQ_CONST, halfSteps)));
  }


  private final float frequency;

  public NoteValue(float frequency) {
    this.frequency = frequency;
  }

  public float getFrequency() {
    return frequency;
  }

  int getOctave() {
    int numHalfSteps = (int) round( log(frequency/A4) / log(FREQ_CONST) );
    int octavesFromA4 = numHalfSteps / NUM_HALF_STEPS_IN_OCTAVE;
    int halfStepsFromA = numHalfSteps % NUM_HALF_STEPS_IN_OCTAVE;

    if (halfStepsFromA + A_INDEX < 0)   octavesFromA4 -= 1;
    if (halfStepsFromA + A_INDEX >= 12) octavesFromA4 += 1;

    return 4 + octavesFromA4;
  }

  NoteName getName() {
    int numHalfSteps = (int) round( log(frequency/A4) / log(FREQ_CONST) );

    int halfStepsFromA = numHalfSteps % NUM_HALF_STEPS_IN_OCTAVE;

    if (halfStepsFromA + A_INDEX < 0)   halfStepsFromA += 12;
    if (halfStepsFromA + A_INDEX >= 12) halfStepsFromA -= 12;

    return NoteName.values()[A_INDEX + halfStepsFromA];
  }

  /**
   * The line is the position on the staff where the note should lie. The top
   * space is 0, and the line below it is 1, etc. To go above the line, use
   * negative values.
   */
  public int getStaffPosition() {
    return 62 - (12*getOctave()) - NoteName.staffDiff(getName()); // A4 = 5, A0 = 53, C0 = 62
  }

  @Override
  public String toString() {
    return getName().toString() + getOctave();
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof NoteValue)) return false;
    else {
      NoteValue n = (NoteValue)o;
      return getName().equals(n.getName()) && getOctave()== n.getOctave();
    }
  }

  @Override
  public int hashCode() {
    return 17 * (getOctave() + 31*getName().hashCode());
  }
}
