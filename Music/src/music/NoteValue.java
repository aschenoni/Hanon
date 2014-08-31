package music;

import static java.lang.Math.*;

public class NoteValue {
  private enum NoteName {
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

  public static final int A_INDEX = NoteName.indexOf(NoteName.A);
  public static final int NUM_HALF_STEPS_IN_OCTAVE = 12;
  public static final float FREQ_CONST = (float) pow(2.0, (1.0 / NUM_HALF_STEPS_IN_OCTAVE));

  private final NoteName name;
  private final int octave;

  public static NoteValue fromFrequency(float frequency) {
    int numHalfSteps = (int) round( log(frequency/A4) / log(FREQ_CONST) );
    int octavesFromA4 = numHalfSteps / NUM_HALF_STEPS_IN_OCTAVE;
    int halfStepsFromA = numHalfSteps % NUM_HALF_STEPS_IN_OCTAVE;

    return new NoteValue(NoteName.values()[A_INDEX + halfStepsFromA], 4 + octavesFromA4);
  }

  public NoteValue(NoteName name, int octave) {
    this.name = name;
    this.octave = octave;
  }

  public float getFrequency() {
    int ind = NoteName.indexOf(name);
    int halfStepsFromA = ind - A_INDEX;
    int octavesFromA4 = octave - 4;
    int halfStepsFromA4 = NUM_HALF_STEPS_IN_OCTAVE * octavesFromA4 + halfStepsFromA;
    return (float) (A4 * pow(FREQ_CONST, halfStepsFromA4));
  }

  @Override
  public String toString() {
    return name.toString() + octave;
  }
}
