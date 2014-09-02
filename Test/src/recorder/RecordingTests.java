package recorder;

import org.junit.Assert;
import org.junit.Test;

import javax.sound.sampled.AudioFileFormat;

public class RecordingTests {

  @Test
  public void testRecordSound() {
    Recording rec = new MockRecording();
    SoundDevice device = new MockSoundDevice(rec);
    Assert.assertEquals(rec, device.getSound(AudioFileFormat.Type.WAVE));
  }


}
