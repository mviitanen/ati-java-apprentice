package org.familysearch.viitanenm;

/**
 * A specialized Exception that also captures the error code
 */
public class MyException extends Exception {

  private int errorCode;

  public MyException(int errorCode) {
    this.errorCode = errorCode;
  }

  public MyException(Throwable cause, int errorCode) {
    super(cause);
    this.errorCode = errorCode;
  }

  public MyException(String message, int errorCode) {
    super(message);
    this.errorCode = errorCode;
  }

  public MyException(String message, Throwable cause, int errorCode) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public int getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String getMessage() {
    return super.getMessage() + " (" + this.getErrorCode() + ")";
  }
}