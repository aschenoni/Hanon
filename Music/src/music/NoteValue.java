package music;

import static java.lang.Math.*;

public class NoteValue {
  private final float frequency;

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

  }
  public static final float A4 = 440.0f;
  private static final int A_INDEX = NoteName.indexOf(NoteName.A);

  private static final int NUM_HALF_STEPS_IN_OCTAVE = 12;
  private static final float FREQ_CONST = (float) pow(2.0, (1.0 / NUM_HALF_STEPS_IN_OCTAVE));

  public NoteValue(float frequency) {
    this.frequency = frequency;
  }

  public float getFrequency() {
    return frequency;
  }

  public int getOctave() {
    int numHalfSteps = (int) round( log(frequency/A4) / log(FREQ_CONST) );
    int octavesFromA4 = numHalfSteps / NUM_HALF_STEPS_IN_OCTAVE;
    int halfStepsFromA = numHalfSteps % NUM_HALF_STEPS_IN_OCTAVE;

    if (halfStepsFromA + A_INDEX < 0)   octavesFromA4 -= 1;
    if (halfStepsFromA + A_INDEX >= 12) octavesFromA4 += 1;

    return 4 + octavesFromA4;
  }

  public NoteName getName() {
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
    return 61 - 12*getOctave() - NoteName.indexOf(getName()); // A4 = 4, A0 = 52, C0 = 61
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
