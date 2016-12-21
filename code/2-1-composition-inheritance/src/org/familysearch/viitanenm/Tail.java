package org.familysearch.viitanenm;

/**
 * Created by viitanenm on 12/9/16.
 */
public class Tail {
  private boolean docked;
  private int length;

  public Tail() {
    this(false, 0);
  }

  public Tail(boolean docked, int length) {
    this.docked = docked;
    this.length = length;
  }

  @Override
  public String toString() {
    return "Tail{" +
        "docked=" + docked +
        ", length=" + length +
        '}';
  }

  public boolean isDocked() {
    return docked;
  }

  public void setDocked(boolean docked) {
    this.docked = docked;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }
}
