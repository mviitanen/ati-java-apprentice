package org.familysearch.viitanenm;

public class Main {

    public static void main(String[] args){
      String newStr = new String("test");
      String newStr2 = new String("test");
      String newStr3 = newStr;
      String literalStr = "test";
      String internalStr = newStr.intern();

      // comparisons
      compareStrings("newStr", newStr, "literalStr", literalStr);
      compareStrings("newStr", newStr, "newStr2", newStr2);
      compareStrings("newStr", newStr, "newStr3", newStr3);
      compareStrings("newStr", newStr, "internalStr", internalStr);
      compareStrings("literalStr", literalStr, "internalStr", internalStr);
    }

  private static void compareStrings(String s1label, String s1, String s2label, String s2) {
    System.out.printf("%-11s and %-11s are %s the same\n" , s1label, s2label, (s1 == s2 ? "" : " not") );
    System.out.printf("%-11s and %-11s are %s equal\n\n" , s1label, s2label, (s1.equals(s2) ? "" : " not") );
  }
}
