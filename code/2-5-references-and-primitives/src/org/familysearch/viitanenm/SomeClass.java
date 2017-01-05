package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/14/16.
 */
public class SomeClass {
  private String someStr;
  private int someInt;

  public SomeClass(int someInt, String someStr) {
    this.someInt = someInt;
    this.someStr = someStr;
  }

  public int getSomeInt() {
    return someInt;
  }

  public void setSomeInt(int someInt) {
    this.someInt = someInt;
  }

  public String getSomeStr() {
    return someStr;
  }

  public void setSomeStr(String someStr) {
    this.someStr = someStr;
  }

  @Override
  public String toString() {
    return "SomeClass:{\n" +
        " someInt=" + someInt + ",\n" +
        " someStr='" + someStr + "'\n" +
        '}';
  }
}
