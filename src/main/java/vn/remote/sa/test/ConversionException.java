package vn.remote.sa.test;

/**
 * Customized exception class for conversion process.
 * 
 * @author truong.le
 */
public class ConversionException extends Exception {

  private static final long serialVersionUID = 2740668894336758759L;

  /**
   * Default constructor.
   */
  public ConversionException() {
    super("Error when converting.");
  }

  /**
   * Constructs the conversion exception from message.
   * 
   * @param message exception message
   */
  public ConversionException(final String message) {
    super(message);
  }

  /**
   * Constructs the conversion exception from message and root cause.
   * 
   * @param message exception message
   * @param throwable the exception root cause
   */
  public ConversionException(final String message, final Throwable throwable) {
    super(message, throwable);
  }

}
