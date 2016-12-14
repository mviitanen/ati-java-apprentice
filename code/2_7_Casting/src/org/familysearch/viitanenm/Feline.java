package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Feline extends Animal {
  private boolean cute;

  public Feline(String name, boolean cute) {
    super(name, 4);
    this.setCute(cute);
  }

  public boolean isCute() {
    return cute;
  }

  public void setCute(boolean cute) {
    this.cute = cute;
  }

  @Override
  public String toString() {
    return "Feline{" +
        "cute=" + cute +
        '}';
  }
}
