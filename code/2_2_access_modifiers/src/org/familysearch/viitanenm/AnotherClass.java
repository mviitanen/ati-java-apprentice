package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class AnotherClass {

  @Override
  public String toString() {
    SomeClass someClass = new SomeClass();
    String str = "";
    str += "A class accessing another class in the same package\n";
    str += str.replaceAll(".", "=");
    str += "private field:    NO ACCESS \n";
    str += "private method:   NO ACCESS \n";
    str += "public field:     " + someClass.publicField + "\n";
    str += "public method:    " + someClass.publicMethod() + "\n";
    str += "protected field:  " + someClass.protectedField + "\n";
    str += "protected method: " + someClass.protectedMethod() + "\n";
    str += "default field:    " + someClass.defaultField + "\n";
    str += "default method:   " + someClass.defaultMethod() + "\n";
    return str;
  }
}
