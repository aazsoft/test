package vn.remote.sa.test;

/**
 * Sub-class for exception handling when invalid source input.
 * 
 * @author truong.le
 */
public class InvalidTargetInputException extends ConversionException {

  private static final long serialVersionUID = -3581329335058016888L;

  /**
   * Default constructor.
   */
  public InvalidTargetInputException() {
    super("Invalid conversion target input.");
  }

  /**
   * Constructs the invalid source exception instance from message.
   * 
   * @param message the exception message
   */
  public InvalidTargetInputException(final String message) {
    super(message);
  }
}
