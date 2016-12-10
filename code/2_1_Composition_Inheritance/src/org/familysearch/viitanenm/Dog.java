package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Dog extends Animal {

  private int wagCount;

  public Dog(String name, Sociability sociability, int wagCount, Tail tail) {
    super.setName(name);
    super.setSociability(sociability);
    super.setNumberOfLegs(4);
    this.setWagCount(wagCount);
    super.setTail(tail);
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
