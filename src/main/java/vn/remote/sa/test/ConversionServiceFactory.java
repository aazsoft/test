package vn.remote.sa.test;

/**
 * Service factory implementation class.
 * <p>
 * this class is to create the conversion service based on the input conversion mode. In reality, to
 * manage the bean of the service, it is recommended using Spring bean to with
 * annotation @org.springframework.stereotype.Service. This case is just a prototpe
 * 
 * @author truong.le
 */
public class ConversionServiceFactory {

  /**
   * Creates the appropriate conversion service implementation from the input context.
   * <p>
   * only supported those following conversion service implementation
   * <ul>
   * <li>{@link C2FConversionServiceImpl}: to convert from Celsius to Fahrenheit</li>
   * <li>{@link K2CConversionServiceImpl}: to convert from Kelvin to Celsius</li>
   * <li>{@link F2KConversionServiceImpl}: to convert from Fahrenheit to Kelvin</li>
   * </ul>
   * 
   * @param context the conversion context.
   * @return the implementation of {@link ITemperatureConverter} interface
   */
  public static ITemperatureConverter create(final ConversionContext context) {
    final TemperatureUnit sourceUnit = context.getSource().getUnit();
    final TemperatureUnit targetUnit = context.getTarget().getUnit();
    // we can save the support methods into a table 2-dimension array and mark the connections
    // between them as 1 which indicates there is a support conversion between them. Like as the
    // following:
    /**
     * <pre>
     *   C F K
     * C 0 1 0 -- support conversion from C to F
     * F 0 0 1 -- support conversion from F to K
     * K 1 0 0 -- support conversion from K to C
     * </pre>
     */
    if (sourceUnit.isC() && targetUnit.isF()) {
      return new C2FConversionServiceImpl();
    }
    if (sourceUnit.isK() && targetUnit.isC()) {
      return new K2CConversionServiceImpl();
    }
    if (sourceUnit.isF() && targetUnit.isK()) {
      return new F2KConversionServiceImpl();
    }
    throw new IllegalArgumentException("Unsupported this kind of conversion method.");
  }
}
