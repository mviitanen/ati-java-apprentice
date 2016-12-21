package org.familysearch.viitanenm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class StringBufferStringBuilderExample {
  private static final String SHORT_STR = "a";
  private static final String KINDA_SHORT_STR = "aaaaa";
  private static final String MEDIUM_STR = "aaaaaaaaaa";
  private static final String KINDA_LONG_STR = "aaaaaaaaaaaaaaaaaaaaaaaaa";
  private static final String LONG_STR = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
  private static final String[] strs = {SHORT_STR, KINDA_SHORT_STR, MEDIUM_STR, KINDA_LONG_STR, LONG_STR};
  private static long start;
  private static long end;
  private static long delta;
  private static NumberFormat fmt = new DecimalFormat("#0.000000000");

  public static void main(String[] args) {
    Writer builderWriter = null;
    Writer bufferWriter = null;
    try {
      builderWriter = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("builder.txt"), "utf-8"));
      bufferWriter = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("buffer.txt"), "utf-8"));
      for (String str : strs) {
        long bufferStrTotal = 0;
        long builderStrTotal = 0;
        int counter = 0;
        for (int i = 1000000; i <= 10000000; i += 1000000) {
          doItBuffer(str, i, bufferWriter);
          bufferStrTotal += delta;
          doItBuilder(str, i, builderWriter);
          builderStrTotal += delta;
          counter++;
        }
        System.out.println("Buffer average by string length (" + str.length() + "):" + (bufferStrTotal / counter));
        System.out.println("Builder average by string length (" + str.length() + "):" + (builderStrTotal / counter));
      }

      for (int i = 1000000; i <= 10000000; i += 1000000) {
        long bufferStrTotal = 0;
        long builderStrTotal = 0;
        int counter = 0;
        for (String str : strs) {
          doItBuffer(str, i, bufferWriter);
          bufferStrTotal += delta;
          doItBuilder(str, i, builderWriter);
          builderStrTotal += delta;
          counter++;
        }
        System.out.println("Buffer average by additions (" + i + "):" + (bufferStrTotal / counter));
        System.out.println("Builder average by additions (" + i + "):" + (builderStrTotal / counter));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (builderWriter != null) {
        try {
          builderWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (bufferWriter != null) {
        try {
          bufferWriter.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private static void doItBuffer(String str, int counter, Writer writer) throws IOException {
    String msg = "";
    StringBuffer buffer = new StringBuffer();
    try {
      start = System.currentTimeMillis();
      for (int i = 0; i < counter; i++) {
        buffer.append(str);
      }
      end = System.currentTimeMillis();
      delta = end - start;
    } catch (Throwable e) {
      delta = 0;
    } finally {

      String fullMsg = str.length() + "\t" + counter + "\t" + delta + "\t" + fmt.format(((double) delta / (double) counter)) + "\tbuffer\t" + msg;
      writer.append(fullMsg + "\n");
      //System.out.println(fullMsg);
    }
  }

  private static void doItBuilder(String str, int counter, Writer writer) throws IOException {
    String msg = "";
    StringBuilder builder = new StringBuilder();
    try {
      start = System.currentTimeMillis();
      for (int i = 0; i < counter; i++) {
        builder.append(str);
      }
      end = System.currentTimeMillis();
      delta = end - start;
    } catch (Throwable e) {
      msg = "E!";
      delta = 0;
    } finally {

      String fullMsg = str.length() + "\t" + counter + "\t" + delta + "\t" + fmt.format(((double) delta / (double) counter)) + "\tbuilder\t" + msg;
      writer.append(fullMsg + "\n");
      //System.out.println(fullMsg);
    }
  }
}