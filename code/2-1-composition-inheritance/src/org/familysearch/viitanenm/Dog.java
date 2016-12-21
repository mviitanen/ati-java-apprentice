package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Dog extends Animal {

  private int wagCount;

  public Dog(String name, Sociability sociability, int wagCount, Tail tail) {
    super(name, 4, sociability, tail);
    this.setWagCount(wagCount);
  }

  public Dog(String name, Sociability sociability, int wagCount) {
    this(name,sociability, wagCount, new Tail());
  }

  public Dog(String name, Sociability sociability) {
    this(name,sociability, 0);
  }

  public Dog(String name) {
    this(name,Sociability.SOCIAL);
  }

  public int getWagCount() {
    return wagCount;
  }

  public void setWagCount(int wagCount) {
    this.wagCount = wagCount;
  }

  @Override
  public String say() {
    String whatDoesTheCatSay = "Bark";
    for (int i = 0; i < wagCount; i++) {
      whatDoesTheCatSay += " (wag)";
    }
    super.walk();
    return whatDoesTheCatSay;
  }
}
