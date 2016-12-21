package org.familysearch.viitanenm;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class ReverseSortInMemoryExample {
  public static void main(String[] args) {
    try {
      new ReverseSortInMemoryExample().doIt();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void doIt() throws IOException {
    sortInMemory();
  }

  private void sortInMemory() throws IOException {
    Path in = Paths.get(".", "lorem.txt");
    List<String> lines = Files.readAllLines(in);
    lines.sort(new Comparator<String>() {
      @Override
      public int compare(String left, String right) {
        return right.compareTo(left);
      }
    });
    Writer writer = null;
    try {
      writer = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("reverse-out-in-memory.txt"), "utf-8"));
      for (String line : lines) {

        writer.write(line + '\n');
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (writer != null) {
        try {
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}