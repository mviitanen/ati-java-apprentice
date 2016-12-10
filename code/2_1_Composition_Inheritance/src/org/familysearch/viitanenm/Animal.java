package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
abstract public class Animal {
  private String name;
  private Sociability sociability;
  private int numberOfLegs;
  private Tail tail;

  public static String adopt() {
    return "Yay! Adopted Animal!";
  }

  public Tail getTail() {
    return tail;
  }

  public void setTail(Tail tail) {
    this.tail = tail;
  }

  public int getNumberOfLegs() {
    return numberOfLegs;
  }

  public void setNumberOfLegs(int numberOfLegs) {
    this.numberOfLegs = numberOfLegs;
  }

  public Sociability getSociability() {
    return sociability;
  }

  public void setSociability(Sociability sociability) {
    this.sociability = sociability;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public abstract String say();

  @Override
  public String toString() {
    String animalStr = "Animal{" +
        "name='" + name + '\'' +
        ", sociability=" + sociability +
        ", numberOfLegs=" + numberOfLegs +
        ", tail=" + tail +
        '}';

    animalStr += this.say();
    return animalStr;
  }

  void walk() {
    String steps = this.getName() + " walks: ";
    for (int i = 0; i < numberOfLegs; i++) {
      steps += " step";
    }
    System.out.println(steps);
  }

  enum Sociability {
    VERY_UNSOCIAL,
    SOMEWHAT_UNSOCIAL,
    SOCIAL,
    SOMEWHAT_SOCIAL,
    VERY_SOCIAL
  }
}
