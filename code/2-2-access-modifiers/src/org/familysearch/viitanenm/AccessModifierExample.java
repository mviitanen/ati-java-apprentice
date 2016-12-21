package org.familysearch.viitanenm;

import org.familysearch.viitanenm.anotherpackage.AnotherPackageChildClass;
import org.familysearch.viitanenm.anotherpackage.AnotherPackageClass;

public class AccessModifierExample {

  public static void main(String[] args) {
    new AccessModifierExample().doIt();
  }

  private void doIt() {
    SomeClass someClass = new SomeClass();
    System.out.println(someClass.toString());

    ChildClass child = new ChildClass();
    System.out.println(child.toString());

    AnotherClass another = new AnotherClass();
    System.out.println(another.toString());

    AnotherPackageChildClass anotherPackageChildClass = new AnotherPackageChildClass();
    System.out.println(anotherPackageChildClass.toString());

    AnotherPackageClass anotherPackageClass = new AnotherPackageClass();
    System.out.println(anotherPackageClass.toString());

    SomeClass.InnerClass innerClass = someClass.new InnerClass();
    System.out.println(innerClass.toString());
  }
}
