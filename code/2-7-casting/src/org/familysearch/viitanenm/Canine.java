package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public abstract class Canine extends Animal {

  private boolean rabies;

  public Canine(String name, boolean rabies) {
    super(name, 4);
    this.rabies = rabies;
  }

  public boolean isRabies() {
    return rabies;
  }

  public void setRabies(boolean rabies) {
    this.rabies = rabies;
  }

  @Override
  public String toString() {
    return "Canine{" +
        "rabies=" + rabies +
        '}';
  }
}
