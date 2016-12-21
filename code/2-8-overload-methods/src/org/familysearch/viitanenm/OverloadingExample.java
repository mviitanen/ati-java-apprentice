package org.familysearch.viitanenm;

public class OverloadingExample {

  public static void main(String[] args) {
    new OverloadingExample().doIt();
  }

  private void doIt() {
    SomeClass someClass = new SomeClass();
    System.out.println(someClass.overloadedMethod(42));
    System.out.println(someClass.overloadedMethod(42.0F));
    System.out.println(someClass.overloadedMethod("42"));
    System.out.println(someClass.overloadedMethod(new Integer(42)));
  }
}
