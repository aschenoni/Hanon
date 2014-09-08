package recorder;

import org.junit.Assert;
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
