package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Dog extends Canine {

  private int wagCount;

  public Dog(String name, int wagCount) {
    super(name, false);
    this.setWagCount(wagCount);
  }

  public int getWagCount() {
    return wagCount;
  }

  public void setWagCount(int wagCount) {
    this.wagCount = wagCount;
  }

  @Override
  public String toString() {
    return super.toString() + " Dog{" +
        "wagCount=" + wagCount +
        '}';
  }
}
