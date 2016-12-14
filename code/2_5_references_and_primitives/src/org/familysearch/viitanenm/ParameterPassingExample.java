package org.familysearch.viitanenm;

public class ParameterPassingExample {

  public static void main(String[] args) {
    new ParameterPassingExample().doIt();
  }

  private void doIt() {
    String originalStr = "Hello World!";
    int originalInt = 42;
    int anotherInt = 42;
    SomeClass someClass = new SomeClass(42, "Hello World!");
    SomeClass anotherClass = new SomeClass(77, "This class is passed as final");

    System.out.println("String: " + originalStr);
    System.out.println("int: " + originalInt);
    System.out.println("final int: " + anotherInt);
    System.out.println("SomeClass: " + someClass.toString());
    System.out.println("AnotherClass: " + anotherClass.toString());

    methodThatModifies(originalInt, originalStr, someClass);
    methodThatModifiesFinals(anotherInt, anotherClass);

    System.out.println("\nAFTER MODIFYING");
    System.out.println("String: " + originalStr);
    System.out.println("int: " + originalInt);
    System.out.println("final int: " + anotherInt);
    System.out.println("SomeClass: " + someClass.toString());
    System.out.println("AnotherClass: " + anotherClass.toString());
  }

  private void methodThatModifies(int anInt, String aStr, SomeClass someClass) {
    anInt += 100;
    aStr += " (Modified)";
    someClass.setSomeInt(someClass.getSomeInt() + 100);
    someClass.setSomeStr(someClass.getSomeStr() + " (Modified)");

    System.out.println("\nAfter modifying in the method:");
    System.out.println("String: " + aStr);
    System.out.println("int: " + anInt);
    System.out.println("SomeClass: " + someClass.toString());
  }


  private void methodThatModifiesFinals(final int finalInt, final SomeClass finalClass) {
    // compiler error: cannot assign a value to a final.
    //finalInt += 100;

    // we can change this because we are not assigning a new reference
    finalClass.setSomeInt(finalClass.getSomeInt() + 100);
    finalClass.setSomeStr(finalClass.getSomeStr() + " (Modified)");

    // Compiler error: cannot assign a new value to the reference
    //finalClass = new SomeClass(99, "Final");

    System.out.println("\nAfter modifying in the method:");
    System.out.println("final int: " + finalInt);
    System.out.println("Final: " + finalClass.toString());
  }
}