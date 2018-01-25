package vn.remote.sa.test;

/**
 * Fahrenheit to Kelvin service implementation class.
 * <p>
 * Assume that the formula to convert the temperature T in Fahrenheit (°F) to the temperature T in
 * Kelvin (K):
 * <p>
 * <strong> T(K) = (T(°F) + 459.67)× 5/9</strong>
 * 
 * @author truong.le
 */
public class F2KConversionServiceImpl implements ITemperatureConverter {

  @Override
  public double convert(double src) {
    return MathUtils.round2Digits((src + 459.67) * 5 / 9);
  }

}
