package org.familysearch.viitanenm;

/**
 * This class is to demonstrate that we cannot assign weaker access privileges to an
 * overridden method.
 */
public class ImmutableCat extends Cat {

  public ImmutableCat(String name, int furballCount, Tail tail) {
    super(name, furballCount, tail);
  }

  public int getFurballCount() {
    return super.getFurballCount();
  }

  // does not compile
/*  @Override
 private void setFurballCount(int furballCount) {
    // don't let them set it
  }
*/
}
