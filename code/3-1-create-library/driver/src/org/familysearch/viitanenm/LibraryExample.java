package org.familysearch.viitanenm;

public class LibraryExample {

  public static void main(String[] args) {
    new LibraryExample().doIt();
  }

  private void doIt() {
    LibraryClass libraryClass = new LibraryClass();
    System.out.println(libraryClass.echo("Hello Library!"));
  }
}
