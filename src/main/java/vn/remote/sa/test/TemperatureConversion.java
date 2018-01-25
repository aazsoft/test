package vn.remote.sa.test;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * The temperature conversion main class.
 * 
 * @author truong.le
 */
public class TemperatureConversion {

  /** Logger definition for this class using SLF4J, asynchronously execution */
  private static final Logger LOG = LoggerFactory.getLogger(TemperatureConversion.class);

  private static final String C_UNIT = TemperatureUnit.C.name();
  private static final String K_UNIT = TemperatureUnit.K.name();
  private static final String F_UNIT = TemperatureUnit.F.name();


  /**
   * Current conversion context attribute, like Builder pattern, it will append the parameters and
   * return the current context instance.
   */
  private ConversionContext context;

  /**
   * Main method to test the temperature conversion.
   * 
   * @param args the arguments input from console
   * @throws Exception thrown when program fails.
   */
  public static void main(String[] args) throws Exception {
    // convert from Celsius temperature degree to Fahrenheit temperature
    final double celsius = 0;
    final String logMsgFormat = "{} in {} equals to {} in {}";
    double fahrenResult = new TemperatureConversion().convert(celsius, C_UNIT).to(F_UNIT).execute();
    LOG.info(logMsgFormat, celsius, C_UNIT, fahrenResult, F_UNIT);
    // convert from Kelvin temperature degree to Celsius temperature
    final double kelvin = 273.15;
    double celsiusResult = new TemperatureConversion().convert(kelvin, K_UNIT).to(C_UNIT).execute();
    LOG.info(logMsgFormat, kelvin, K_UNIT, celsiusResult, C_UNIT);
    // convert from Fahrenheit temperature degree to Kelvin temperature
    final double fahrenheit = 32;
    double kelvinResult =
        new TemperatureConversion().convert(fahrenheit, F_UNIT).to(K_UNIT).execute();
    LOG.info(logMsgFormat, fahrenheit, F_UNIT, kelvinResult, K_UNIT);

    // invalid conversion
    // not supported source or target temperature unit
    new TemperatureConversion().convert(fahrenheit, "U").to(F_UNIT).execute();
    new TemperatureConversion().to("U").execute();
    // no source to convert
    new TemperatureConversion().to(F_UNIT).execute();
    // no target temperature unit to convert
    new TemperatureConversion().convert(fahrenheit, F_UNIT).execute();
    // no input for source temperature unit
    new TemperatureConversion().convert(fahrenheit, null).to(F_UNIT).execute();
  }

  /**
   * Default constructor.
   */
  public TemperatureConversion() {
    this.context = new ConversionContext();
  }

  /**
   * Returns the {@link TemperatureConversion} instance with current source conversion context.
   * 
   * @param temperature the source temperature degree to convert.
   * @param unit the source temperature unit
   * @return the {@link TemperatureConversion} instance.
   */
  public TemperatureConversion convert(final double temperature, final String unit) {
    if (StringUtils.isBlank(unit)) {
      throw new IllegalArgumentException("Temperature unit should not be null or empty");
    }
    this.context.buildSource(temperature, TemperatureUnit.valueOf(unit));
    return this;
  }

  /**
   * Returns the {@link TemperatureConversion} instance with current target conversion context.
   * 
   * @param unit the target temperature unit
   * @return the {@link TemperatureConversion} instance.
   */
  public TemperatureConversion to(final String unit) {
    if (StringUtils.isBlank(unit)) {
      throw new IllegalArgumentException("Temperature unit should not be null or empty");
    }
    this.context.buildTarget(TemperatureUnit.valueOf(unit));
    return this;
  }

  /**
   * Executes the conversion.
   * 
   * @return the corresponding target temperature degree
   * @throws ConversionException thrown when program fails.
   */
  public double execute() throws ConversionException {
    // validate valid arguments
    if (Objects.isNull(this.context.getSource())) {
      // log error and throw exception
      LOG.error("Source temperature input should not be null");
      throw new InvalidSourceInputException();
    }
    if (Objects.isNull(this.context.getTarget())) {
      // log error and throw exception
      LOG.error("Target temperature input should not be null");
      throw new InvalidTargetInputException();
    }
    return ConversionServiceFactory.create(context).convert(context.getSource().getTemperature());
  }
}
