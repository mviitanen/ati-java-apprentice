package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public enum ApplicationError {
  E404(404, "Not Found"),
  E500(500, "Really Bad Error"),
  UNKNOWN(0, "Unknown");

  private int errorCode;
  private String errorMessage;

  ApplicationError(int errorCode, String errorMessage) {
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
  }

  public static ApplicationError fromValue(int errorCode) {
    ApplicationError[] values = ApplicationError.values();
    for (ApplicationError value : values) {
      if (value.getErrorCode() == errorCode) {
        return value;
      }
    }
    return UNKNOWN;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  /**
   * Returns the name of this enum constant, as contained in the
   * declaration.  This method may be overridden, though it typically
   * isn't necessary or desirable.  An enum type should override this
   * method when a more "programmer-friendly" string form exists.
   *
   * @return the name of this enum constant
   */
  @Override
  public String toString() {
    return this.getErrorMessage() + "(" + this.getErrorCode() + ")";
  }
}
