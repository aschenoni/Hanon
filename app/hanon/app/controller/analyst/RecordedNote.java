package hanon.app.controller.analyst;

import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.Yin;
import hanon.app.controller.music.MusicNote;
import hanon.app.controller.music.NoteValue;

public class RecordedNote extends MusicNote {
  public static RecordedNote fromSoundArr(float[] floatArr) {
    Yin pitch = new Yin(8000, 1024);
    PitchDetectionResult pdr = pitch.getPitch(floatArr);
    return fromFrequency(pdr.getPitch());
  }

  public static RecordedNote fromFrequency(float frequency) {
    NoteValue value = new NoteValue(frequency);
    return new RecordedNote(value);
  }

  private RecordedNote(NoteValue value) {
    super(value, null); // TODO how do we get note length from array of floats?
  }

  /**
   * @return the difference between the actual note frequency and the closest
   * theoretical note frequency.
   *
   * Example: a 450 Hz note would yield 10, because the closest theoretical
   * note is 440 Hz (A4)
   */
  public float getFrequencyOffset() {
    int closestOctave = getValue().getOctave();
    NoteValue.NoteName closestName = getValue().getName();
    NoteValue closestValue = NoteValue.fromNameAndOctave(closestName, closestOctave);
    float offset = getValue().getFrequency() - closestValue.getFrequency();
    return offset;
  }
}
