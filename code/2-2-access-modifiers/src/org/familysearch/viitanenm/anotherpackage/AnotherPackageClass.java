package org.familysearch.viitanenm.anotherpackage;

import org.familysearch.viitanenm.SomeClass;

/**
 * Created by viitanenm on 12/9/16.
 */
public class AnotherPackageClass {

  @Override
  public String toString() {
    SomeClass someClass = new SomeClass();
    String str = "";
    str += "A class accessing a class in another package\n";
    str += str.replaceAll(".", "=");
    str += "private field:    NO ACCESS \n";
    str += "private method:   NO ACCESS \n";
    str += "public field:     " + someClass.publicField + "\n";
    str += "public method:    " + someClass.publicMethod() + "\n";
    str += "protected field:  NO ACCESS\n";
    str += "protected method: NO ACCESS\n";
    str += "default field:    NO ACCESS \n";
    str += "default method:   NO ACCESS \n";
    return str;
  }
}
