package org.familysearch.viitanenm.anotherpackage;

import org.familysearch.viitanenm.SomeClass;

/**
 * Created by viitanenm on 12/9/16.
 */
public class AnotherPackageChildClass extends SomeClass {

  @Override
  public String toString() {
    String str = "";
    str += "A class accessing the super class in another package\n";
    str += str.replaceAll(".", "=");
    str += "private field:    NO ACCESS \n";
    str += "private method:   NO ACCESS \n";
    str += "public field:     " + super.publicField + "\n";
    str += "public method:    " + super.publicMethod() + "\n";
    str += "protected field:  " + super.protectedField + "\n";
    str += "protected method: " + super.protectedMethod() + "\n";
    str += "default field:    NO ACCESS \n";
    str += "default method:   NO ACCESS \n";
    return str;
  }
}
