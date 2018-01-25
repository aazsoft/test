package vn.remote.sa.test;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

/**
 * MathUtils test class.
 * 
 * @author truong.le
 */
public class MathUtilsTest {

  @Test
  public void givenDoubleValue_ShouldRoundUpTo2DecimalPlacesValue() {
    Assert.assertThat(MathUtils.round2Digits(2.12561), Matchers.is(2.13));
  }

  @Test
  public void givenDoubleValue_ShouldRoundDownTo2DecimalPlacesValue() {
    Assert.assertThat(MathUtils.round2Digits(2.12215), Matchers.is(2.12));
  }
}
