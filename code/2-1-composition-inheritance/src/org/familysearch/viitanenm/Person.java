package org.familysearch.viitanenm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Person {
  private List<Animal> pets = new ArrayList<Animal>();

  public List<Animal> getPets() {
    return pets;
  }

  public void setPets(List<Animal> pets) {
    this.pets = pets;
  }

  public void addPet(Animal pet) {
    if (this.pets == null) {
      this.pets = new ArrayList<Animal>();
    }
    this.pets.add(pet);
  }

  @Override
  public String toString() {
    boolean first = true;
    String personStr = "Person{" +
        "pets=" + getPets() + "}";
    return personStr;
  }
}
