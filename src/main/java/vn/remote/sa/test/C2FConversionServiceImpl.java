package vn.remote.sa.test;

/**
 * Celsius to Fahrenheit service implementation class.
 * <p>
 * Assume that the formula to convert the temperature T in degrees Fahrenheit (°F) to the
 * temperature T in degrees Celsius(°C):
 * <p>
 * <strong> T(°F) = T(°C) × 1.8 + 32</strong>
 * 
 * @author truong.le
 */
public class C2FConversionServiceImpl implements ITemperatureConverter {

  @Override
  public double convert(double src) {
    return MathUtils.round2Digits(src * 1.8 + 32);
  }

}
