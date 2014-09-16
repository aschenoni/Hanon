package recorder;

import hanon.app.model.recorder.Recording;
import hanon.app.model.recorder.SoundDevice;

import org.junit.Test;

import static org.junit.Assert.*;

public class RecordingTests {

  @Test
  public void testRecordSound() {
    Recording rec = new MockRecording();
    SoundDevice device = new MockSoundDevice(rec);
    assertEquals(rec, device.getSound());
  }


}
