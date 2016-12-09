package org.familysearch.viitanenm;


import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
  public static NumberFormat fmt = NumberFormat.getNumberInstance();
  public static void main(String[] args) {
    // Literal Strings
    System.out.println("Literal Strings Not Random");
    doIt(5, true, false);
    doIt(200, true, false);
    doIt(1000, true, false);

    // Dynamic Strings
    System.out.println("Dynamic Strings Not Random");
    doIt(5, false, false);
    doIt(200, false, false);
    doIt(1000, false, false);
    System.out.println("Dynamic Strings Random");
    doIt(1000, false, true);

    //big graph
    System.out.println("Dynamic Strings Not Random at intervals");
    int[] xTics = {30, 40, 50, 60, 70, 80, 90, 100, 150, 200, 250, 300, 350, 400, 450, 500, 600, 700, 800, 900, 1000};
    for(int x : xTics) {
      doIt(x, false, true);
    }
  }

  private static void doIt(int length, boolean literal, boolean random) {
    Random rnd = new Random();
    List<String> list = new ArrayList<String>(1000);
    long counter = 0;
    long charCounter = 0;
    try {
      String strInternal =  genStr(length).intern();
      String str = strInternal;
      do {
        if (!literal) {
          str = genStr(random ? rnd.nextInt(length) : length);
        }
        list.add(str);
        counter++;
        charCounter += str.length();
      }
      while (true);
    } catch (Throwable e) {
      System.out.println((e.getClass().getName()) +": " +  e.getMessage());
      System.out.println(length +" & " + fmt.format(counter) + " & " + fmt.format(charCounter) + " \\\\ \\hline");
      System.out.println("(" + length +"," + charCounter + ")");

      //e.printStackTrace();
    }
  }

  private static String genStr(int length) {
    Random rnd = new Random();
    StringBuilder builder = new StringBuilder(length);
    for (int i = 0; i < length; i++) {
      builder.append((char) (97 + rnd.nextInt(25)));
    }
    return builder.toString();
  }
}

