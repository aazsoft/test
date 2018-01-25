package vn.remote.sa.test;

/**
 * Enumeration class to define various units of temperature.
 * <p>
 * For instance, those units below are supported:
 * <ul>
 * <li>K = Kelvin degree</li>
 * <li>C = Celsius degree</li>
 * <li>F = Fahrenheit degree</li>
 * </ul>
 * 
 * @author truong.le
 */
public enum TemperatureUnit {

  // @formatter:off
  K("Kelvin"), 
  C("Celsius"), 
  F("Fahrenheit"); // @formatter:on

  private String desc; // unit description

  /**
   * Constructs the temperature unit from description.
   * 
   * @param desc the unit description
   */
  TemperatureUnit(final String desc) {
    this.desc = desc;
  }

  /**
   * Returns the unit descriptions.
   * 
   * @return the description
   */
  public String getDesc() {
    return desc;
  }

  /**
   * Checks whether this temperature unit is Kelvin unit.
   * 
   * @return <code>true</code> if this unit is Kelvin, return <code>false</code> otherwise
   */
  public boolean isK() {
    return this == K;
  }

  /**
   * Checks whether this temperature unit is Celsius unit.
   * 
   * @return <code>true</code> if this unit is Celsius, return <code>false</code> otherwise
   */
  public boolean isC() {
    return this == C;
  }

  /**
   * Checks whether this temperature unit is Fahrenheit unit.
   * 
   * @return <code>true</code> if this unit is Fahrenheit, return <code>false</code> otherwise
   */
  public boolean isF() {
    return this == F;
  }
}
