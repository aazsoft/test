package vn.remote.sa.test;

/**
 * Sub-class for exception handling when invalid source input.
 * 
 * @author truong.le
 */
public class InvalidSourceInputException extends ConversionException {

  private static final long serialVersionUID = 7364402486061853278L;

  /**
   * Default constructor.
   */
  public InvalidSourceInputException() {
    super("Invalid conversion source input.");
  }

  /**
   * Constructs the invalid source exception instance from message.
   * 
   * @param message the exception message
   */
  public InvalidSourceInputException(final String message) {
    super(message);
  }
}
