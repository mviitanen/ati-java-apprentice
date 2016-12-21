package org.familysearch.viitanenm;

public class EnumExample {

  public enum NaughtyOrNice {
    REALLY_NICE,
    NICE,
    NOT_SO_NICE,
    AVERAGE_NICE,
    NOT_REALLY_NAUGHTY,
    NAUGHTY,
    REALLY_NAUGHTY
  }

  public static void main(String[] args) {
    new EnumExample().doIt();
  }

  private void doIt() {
    NaughtyOrNice peterStatus = NaughtyOrNice.AVERAGE_NICE;
    System.out.println(peterStatus + " " + " {name:'" + peterStatus.name()+ "', ordinal:'" + peterStatus.ordinal() +"'}");

    if(peterStatus.equals(NaughtyOrNice.REALLY_NAUGHTY)){
      System.out.println("He has no hope");
    }
    else {
      System.out.println("He has some hope");
    }

    // Using a custom enum
    ApplicationError myError = ApplicationError.E404;
    ApplicationError error500 = ApplicationError.fromValue(500);

    // Using an enum in a switch
    System.out.println();
    String msg;
    switch (myError) {
      case E404:
        msg = " -- Where did it go?";
        break;
      case E500:
        msg = " -- Let's just give up";
        break;
      default:
        msg = " -- Who knows?";
        break;
    }

    System.out.println(myError.toString() + msg);
    System.out.println(error500.toString() + " {name:'" + error500.name()+ "', ordinal:'" + error500.ordinal() +"'}");
  }
}
