package vn.remote.sa.test;

import java.math.BigDecimal;

/**
 * Utility class for number.
 * 
 * @author truong.le
 */
public final class MathUtils {

  private MathUtils() {
    // prevent initialization
  }

  public static double round2Digits(double src) {
    BigDecimal val = BigDecimal.valueOf(src); // use BigDecimal class since there are many useful
                                              // supported API to deal with floating point number
    val = val.setScale(2, BigDecimal.ROUND_HALF_EVEN);
    return val.doubleValue();
  }
}
