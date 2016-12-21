package org.familysearch.viitanenm.gc;

/**
 * Created by viitanenm on 12/13/14.
 */
public class DataSizePrinter {

  public static void main(String[] args) {
    // Float.MAX_VALUE is intBitsToFloat(0x7f7fffff)
    // so we set the most significant bit - the sign bit
    float f = Float.intBitsToFloat((int) 0xff7fffff);
    System.out.println(f == -Float.MAX_VALUE); // true
    System.out.println("float from " + -Float.MAX_VALUE + " to " + Float.MAX_VALUE);
    System.out.println("double from " + -Double.MAX_VALUE + " to " + Double.MAX_VALUE);
  }
}
