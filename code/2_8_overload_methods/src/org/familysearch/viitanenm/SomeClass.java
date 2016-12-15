package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class SomeClass {

  public String overloadedMethod(int someNumber) {
    return "" + someNumber;
  }

  public String overloadedMethod(float someNumber) {
    return "" + (int) someNumber;
  }

  public String overloadedMethod(Integer someNumber) {
    return "" + someNumber;
  }

  public String overloadedMethod(String someNumber) {
    return someNumber;
  }

  // Compilation error
  //public int overloadedMethod(String someNumber) {
  //  return Integer.valueOf(someNumber);
  //}
}
