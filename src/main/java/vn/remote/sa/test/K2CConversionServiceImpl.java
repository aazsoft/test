package vn.remote.sa.test;

/**
 * Kelvin to Celsius service implementation class.
 * <p>
 * Assume that the formula to convert the temperature T in Kelvin (K) to the temperature T in
 * degrees Celsius (°C):
 * <p>
 * <strong> T(°C) = T(K) - 273.15</strong>
 * 
 * @author truong.le
 */
public class K2CConversionServiceImpl implements ITemperatureConverter {

  @Override
  public double convert(double src) {
    return MathUtils.round2Digits(src - 273.15);
  }

}
