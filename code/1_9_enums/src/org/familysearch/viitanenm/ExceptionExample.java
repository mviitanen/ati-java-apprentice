package org.familysearch.viitanenm;

public class ExceptionExample {

  private boolean someConditionIsTrue = true;

  public static void main(String[] args) {
    new ExceptionExample().doIt();
  }

  private void doIt() {
    catchCheckedException();
    System.out.println();
    catchThrowError();
    System.out.println();
    catchCustomException();
    System.out.println();
    catchUncheckedException();
  }

  /**
   * Demonstrates throwing an unchecked exception.
   * <p/>
   * Notice how there is no <code>throws</code> statement in the method signature
   */
  private void throwUncheckedException() {
    if (someConditionIsTrue) {
      throw new IllegalArgumentException("This is my error message");
    } else {
      System.out.println("Don't throw it, then...");
    }
  }

  private void catchUncheckedException() {
    System.out.println("About to call a method that throws an unchecked exception, handled");

    try {
      throwUncheckedException();
    } catch (RuntimeException e) {
      System.out.println("Exception caught: " + e.getMessage());
    } finally {
      System.out.println("Finally");
    }
    System.out.println("Done calling a method that throws an unchecked exception, handled");
    System.out.println("About to call a method that throws an unchecked exception, not handled");
    throwUncheckedException();
    System.out.println("Done calling a method that throws an unchecked exception, not handled");
  }

  private void throwCheckedException() throws IllegalArgumentException {
    if (someConditionIsTrue) {
      throw new IllegalArgumentException("This is my custom exception message");
    } else {
      System.out.println("Don't throw it, then...");
    }
  }

  private void catchCheckedException() {
    System.out.println("About to call a method that throws a checked exception, handled");

    try {
      throwCheckedException();
    } catch (IllegalArgumentException e) {
      System.out.println("Exception caught: " + e.getMessage());
    } finally {
      System.out.println("Finally");
    }
    System.out.println("Done calling a method that throws a checked exception, handled");
  }

  private void throwError() {
    throw new UnknownError("This is my unknown error");
  }

  private void catchThrowError() {
    System.out.println("About to call a method that throws an error, handled");

    try {
      throwError();
    } catch (UnknownError e) {
      System.out.println("Error caught: " + e.getMessage());
    } finally {
      System.out.println("Finally");
    }
    System.out.println("Done calling a method that throws an error, handled");
  }

  private void throwCustomException() throws MyException {
    if (someConditionIsTrue) {
      throw new MyException("This is my custom exception message", 404);
    } else {
      System.out.println("Don't throw it, then...");
    }
  }

  private void catchCustomException() {
    System.out.println("About to call a method that throws a custom exception, handled");

    try {
      throwCustomException();
    } catch (MyException e) {
      System.out.println("Exception caught: " + e.getMessage());
    } finally {
      System.out.println("Finally");
    }
    System.out.println("Done calling a method that throws a custom exception, handled");
  }
}
