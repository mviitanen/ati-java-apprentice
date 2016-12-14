package org.familysearch.viitanenm;

public class CastingExample {

  public static void main(String[] args) {
    new CastingExample().doIt();
  }

  private void doIt() {
    Animal pluto = new Dog("Pluto", 3);
    Animal sparky = new Dog("Sparky", 1);

    // Casting
    System.out.println("\nCasting");
    System.out.println(pluto);
    if (pluto instanceof Dog) {
      ((Dog) pluto).setWagCount(10);
      System.out.println(pluto);
    }

    // ClassCastException
    try {
      Cat kittie = (Cat) pluto;
    } catch (ClassCastException e) {
      System.out.println("ClassCastException:" + e.getMessage());

    }

    System.out.println("Runtime type comparison");
    if (pluto.getClass().isAssignableFrom(sparky.getClass())) {
      System.out.println(pluto.getName() + " is the same type as " + sparky.getName());
    }

    // compilation error
    // if(pluto instanceof sparky.getClass()){
    //  System.out.println(pluto.getName() + " is the same type as " + sparky.getName());
  }
}
