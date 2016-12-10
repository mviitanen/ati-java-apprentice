package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Cat extends Animal {
  private int furballCount;

  public Cat(String name, int furballCount, Tail tail) {
    super.setName(name);
    super.setSociability(Sociability.VERY_UNSOCIAL);
    super.setNumberOfLegs(4);
    super.setTail(tail);
    this.setFurballCount(furballCount);
  }

  public int getFurballCount() {
    return furballCount;
  }

  public void setFurballCount(int furballCount) {
    this.furballCount = furballCount;
  }

  @Override
  public String say() {
    String whatDoesTheCatSay = "Meouw";
    for (int i = 0; i < furballCount; i++) {
      whatDoesTheCatSay += " (cough)";
    }
    super.walk();
    return whatDoesTheCatSay;
  }
}
