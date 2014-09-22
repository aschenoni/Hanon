package hanon.app.controller.analyst;

import hanon.app.controller.music.NoteValue;

public class TunerInfo {

  private final float frequency;
  private final NoteValue.NoteName name;
  private final int octave;
  private final float difference;

  public TunerInfo(float frequency, NoteValue.NoteName name, int octave, float difference) {
    this.frequency = frequency;
    this.name = name;
    this.octave = octave;
    this.difference = difference;
  }

  public float getFrequency() {
    return frequency;
  }

  public NoteValue.NoteName getName() {
    return name;
  }

  public int getOctave() {
    return octave;
  }

  public float getDifference() {
    return difference;
  }

  @Override
  public String toString() {
    return "frequency: " + frequency +
            ", name: " + name +
            ", octave: " + octave +
            ", difference: " + difference;
  }
}
