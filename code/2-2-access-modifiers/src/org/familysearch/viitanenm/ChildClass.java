package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class ChildClass extends SomeClass {
  @Override
  public String toString() {
    String str = "";
    str += "A child class accessing the super class\n";
    str += str.replaceAll(".", "=");
    str += "private field:    NO ACCESS \n";
    str += "private method:   NO ACCESS \n";
    str += "public field:     " + super.publicField + "\n";
    str += "public method:    " + super.publicMethod() + "\n";
    str += "protected field:  " + super.protectedField + "\n";
    str += "protected method: " + super.protectedMethod() + "\n";
    str += "default field:    " + super.defaultField + "\n";
    str += "default method:   " + super.defaultMethod() + "\n";
    return str;
  }
}
