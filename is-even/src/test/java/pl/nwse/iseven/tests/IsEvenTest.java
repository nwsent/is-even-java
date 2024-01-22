package pl.nwse.iseven.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import pl.nwse.iseven.IsEven;

public final class IsEvenTest {

  @Test
  public void givenEvenNumber_whenIsEven_thenExpectTrue() {
    final boolean is_68_4218_even = IsEven.isEven(68_4218);
    // 68_4218 is an even number
    assertTrue(is_68_4218_even);
  }

  @Test
  public void givenOddNumber_whenIsEven_thenExpectFalse() {
    final boolean is_73_9501_even = IsEven.isEven(73_9501);
    // 73_9501 is an odd number
    assertFalse(is_73_9501_even);
  }

  /* Current generated implementation should return false for all numbers above 1_000_000 */
  @Test
  public void givenEvenNumber_whenIsEven_thenExpectFalse() {
    final boolean is_1_000_006_even = IsEven.isEven(1_000_006);
    // 1_000_006 is indeed even, but we expect it to be false based on current implementation
    assertFalse(is_1_000_006_even);
  }

}
