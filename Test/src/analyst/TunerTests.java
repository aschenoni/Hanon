package analyst;

import hanon.app.controller.analyst.RecordedNote;
import org.junit.Assert;
import org.junit.Test;

public class TunerTests {

  @Test
  public void testPositiveFrequencyOffset() {
    RecordedNote played = RecordedNote.fromFrequency(450.0f);
    Assert.assertEquals(10.0f, played.getFrequencyOffset(), .1f);
  }

  @Test
  public void testNegativeFrequencyOffset() {
    RecordedNote played = RecordedNote.fromFrequency(430.0f);
    Assert.assertEquals(-10.0f, played.getFrequencyOffset(), .1f);
  }

}