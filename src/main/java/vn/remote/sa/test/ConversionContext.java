package vn.remote.sa.test;

import java.io.Serializable;

/**
 * Conversion context class which defines the attributes for conversion process.
 * 
 * @author truong.le
 */
public class ConversionContext implements Serializable {

  private static final long serialVersionUID = -7672185663358007475L;

  private Source source;
  private Target target;

  public void buildSource(final double temperature, final TemperatureUnit unit) {
    this.source = new Source(temperature, unit);
  }

  public void buildTarget(final TemperatureUnit unit) {
    this.target = new Target(unit);
  }

  public Source getSource() {
    return source;
  }

  public Target getTarget() {
    return target;
  }

  /**
   * Source temperature info class.
   * 
   * @author truong.le
   */
  static class Source implements Serializable {

    private static final long serialVersionUID = -5666516537781047264L;

    private double temperature; // source temperature
    private TemperatureUnit unit; // source temperature unit to convert

    /**
     * Default constructor.
     */
    private Source(final double temperature, final TemperatureUnit unit) {
      this.temperature = temperature;
      this.unit = unit;
    }

    public double getTemperature() {
      return temperature;
    }

    public void setTemperature(double temperature) {
      this.temperature = temperature;
    }

    public TemperatureUnit getUnit() {
      return unit;
    }

    public void setUnit(TemperatureUnit unit) {
      this.unit = unit;
    }
  }

  /**
   * Target temperature info class.
   * 
   * @author truong.le
   */
  static class Target implements Serializable {

    private static final long serialVersionUID = 8005643698148814304L;

    private TemperatureUnit unit; // target temperature unit to convert

    /**
     * Default constructor.
     */
    private Target(final TemperatureUnit unit) {
      this.unit = unit;
    }

    public TemperatureUnit getUnit() {
      return unit;
    }

    public void setUnit(TemperatureUnit unit) {
      this.unit = unit;
    }

  }
}
