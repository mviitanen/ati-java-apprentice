package org.familysearch.viitanenm;

import java.util.ArrayList;
import java.util.List;

public class InheritanceComposistionExample {

  public static void main(String[] args) {
    new InheritanceComposistionExample().doIt();
  }

  private void doIt() {
    Person bob = new Person();
    Tail tail = new Tail(false, 10);
    Animal pluto = new Dog("Pluto", Animal.Sociability.VERY_SOCIAL, 3, tail);
    bob.addPet(pluto);
    System.out.println(bob);


    Dog pepper = new Dog("Pepper", Animal.Sociability.VERY_SOCIAL, 99, new Tail(true, 1));
    System.out.println(pepper);
    System.out.println(pepper.say());
    System.out.println();

    Person betty = new Person();
    Animal sheba = new Cat("Sheba", 2, new Tail(false, 15));
    Animal spot = new Dog("Spot", Animal.Sociability.VERY_SOCIAL, 5, new Tail(false, 8));
    List<Animal> pets = new ArrayList<Animal>();
    pets.add(spot);
    pets.add(sheba);
    betty.setPets(pets);
    System.out.println(betty);
    System.out.println(sheba.say());

    System.out.println();
    System.out.println(Animal.adopt());


    // Constructors
    System.out.println("Constructor test");
    Dog sparky = new Dog("Sparky");
    Dog harley = new Dog("Harley", Animal.Sociability.SOMEWHAT_UNSOCIAL);
    Dog spud = new Dog("Spud", Animal.Sociability.VERY_SOCIAL, 3);
    Dog kingkong = new Dog("King Kong", Animal.Sociability.VERY_SOCIAL, 1, new Tail(true, 1));
    System.out.println(sparky);
    System.out.println(harley);
    System.out.println(spud);
    System.out.println(kingkong);

    // Virtual method call
    System.out.println("\nVirtual Method Call");
    System.out.println(pluto.say());
    System.out.println(sheba.say());

  }
}
