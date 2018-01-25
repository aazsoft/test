package vn.remote.sa.test;

public interface ITemperatureConverter {

  /**
   * Converts the source temperature value to the target value.
   * 
   * @param src the source value
   * @return the target value
   */
  double convert(final double src);
}
