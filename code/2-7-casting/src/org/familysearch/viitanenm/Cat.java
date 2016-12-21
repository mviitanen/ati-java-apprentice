package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Cat extends Feline {
  private int furballCount;

  public Cat(String name, int furballCount) {
    super(name, true);
    this.setFurballCount(furballCount);
  }

  public int getFurballCount() {
    return furballCount;
  }

  public void setFurballCount(int furballCount) {
    this.furballCount = furballCount;
  }

  @Override
  public String toString() {
    return super.toString() + "  Cat{" +
        "furballCount=" + furballCount +
        '}';
  }
}
