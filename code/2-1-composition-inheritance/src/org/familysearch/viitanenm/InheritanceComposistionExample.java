package org.familysearch.viitanenm;

import java.util.ArrayList;
import java.util.List;

public class InheritanceComposistionExample {

  public static void main(String[] args) {
    new InheritanceComposistionExample().doIt();
  }

  private void doIt() {

    // Create Animals
    System.out.println("Creating Animals");
    Dog pluto = new Dog("Pluto", Animal.Sociability.VERY_SOCIAL, 3);
    System.out.println(pluto);

    Animal pepper = new Dog("Pepper", Animal.Sociability.VERY_SOCIAL, 99, new Tail(true, 1));
    System.out.println("Calling the say method");
    System.out.println(pepper.say());
    System.out.println();

    Animal sheba = new Cat("Sheba", 2, new Tail(false, 15));
    System.out.println(sheba.say());

    Animal spot = new Dog("Spot", Animal.Sociability.VERY_SOCIAL, 5, new Tail(false, 8));
    System.out.println("\n\nCalling the walk method of the super");
    System.out.println(spot.walk());

    // Animals in a List
    List<Animal> pets = new ArrayList<Animal>();
    pets.add(spot);
    pets.add(sheba);

    System.out.println("\n\nAnimals in a list");
    for(Animal animal : pets){
      System.out.println(animal);
    }

    // Animal "has-a" Tail
    System.out.println("\n \nAnimal 'has-a' tail");
    Tail tail = new Tail(false, 10);
    pluto.setTail(tail);
    System.out.println(pluto.getTail().isDocked());

    // Person "has-an" Animal

    System.out.println("\n \nPerson 'has-a' pet");
    Person bob = new Person();
    bob.addPet(pluto);
    System.out.println(bob);

    Person betty = new Person();
    betty.setPets(pets);
    System.out.println(betty);

    // Static method call
    System.out.println("\n\nStatic method call");
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
