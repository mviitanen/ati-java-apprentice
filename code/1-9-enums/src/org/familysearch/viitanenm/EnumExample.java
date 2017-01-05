package org.familysearch.viitanenm;

public class EnumExample {

  public static void main(String[] args) {
    new EnumExample().doIt();
  }

  private void doIt() {
    System.out.println("Simple enum example");
    NaughtyOrNice peterStatus = NaughtyOrNice.AVERAGE_NICE;
    System.out.println(peterStatus + ":{\n"
        + " name:'" + peterStatus.name() + "',\n"
        + " ordinal:'" + peterStatus.ordinal() + "'\n" +
        "}");

    if (peterStatus.equals(NaughtyOrNice.REALLY_NAUGHTY)) {
      System.out.println("He has no hope");
    } else {
      System.out.println("He has some hope");
    }

    // Using a custom enum
    ErrorType myError = ErrorType.E404;
    // Using an enum in a switch
    System.out.println("\nCustom enum in a switch");
    String msg;
    switch (myError) {
      case E404:
        msg = "Where did it go?";
        break;
      case E500:
        msg = "Let's just give up";
        break;
      default:
        msg = "Who knows?";
        break;
    }

    System.out.println(myError.name() + " " + msg);

    System.out.println("\nEnum with FromValue");
    // using fromValue
    ErrorType error500 = ErrorType.fromValue(500);
    System.out.println(error500.toString());
  }

  public enum NaughtyOrNice {
    REALLY_NICE,
    NICE,
    NOT_SO_NICE,
    AVERAGE_NICE,
    NOT_REALLY_NAUGHTY,
    NAUGHTY,
    REALLY_NAUGHTY
  }
}
