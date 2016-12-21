package org.familysearch.viitanenm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SortReverseInFileExample {
  private boolean firstLine = true;

  public static void main(String[] args) {
    try {
      new SortReverseInFileExample().doIt();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void doIt() throws IOException {
    long start = System.currentTimeMillis();
    splitLines();
    sortEachFile();
    merge();
    long end = System.currentTimeMillis();
    System.out.println("File sort took: " + (end - start) + " ms");
  }

  private void merge() throws IOException {
    Map<Integer, BufferedReader> readers = initiateReaders();

    // read a line from each file, sort them, and write to the final file.
    Writer writer = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("./out-reverse-final-in-file.txt"), "utf-8"));

    Map<Integer, String> mergeMap = initiateMergeMap(readers);

    do {
      int key = findFirstLine(mergeMap);
      addNewLine(writer);
      writer.append(mergeMap.remove(key));
      reloadMergeMap(readers, mergeMap, key);
    } while (!readers.isEmpty());

    try {
      writer.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void reloadMergeMap(Map<Integer, BufferedReader> readers, Map<Integer, String> mergeMap, int key) throws IOException {
    String nextString = readers.get(key).readLine();
    if (nextString == null) {
      readers.remove(key);
    } else {
      mergeMap.put(key, nextString);
    }
  }

  private Map<Integer, String> initiateMergeMap(Map<Integer, BufferedReader> readers) throws IOException {
    Map<Integer, String> oneLines = new TreeMap<>();
    // load them up
    for (int i = 0; i < 10; i++) {
      oneLines.put(i, readers.get(i).readLine());
    }
    return oneLines;
  }

  private Map<Integer, BufferedReader> initiateReaders() throws FileNotFoundException {
    Map<Integer, BufferedReader> readers = new TreeMap<>();

    for (int i = 0; i < 10; i++) {
      BufferedReader br = new BufferedReader(new FileReader("./out-" + i + ".txt"));
      readers.put(i, br);
    }
    return readers;
  }

  private void addNewLine(Writer writer) throws IOException {
    // prevent empty line in the end of the file. Add a newline in front of the line to be added
    if (firstLine) {
      firstLine = false;
    } else {
      writer.append('\n');
    }
  }

  private int findFirstLine(Map<Integer, String> oneLines) {
    Map.Entry<Integer, String> lowest = null;
    for (Map.Entry<Integer, String> entry : oneLines.entrySet()) {
      if (lowest == null) {
        lowest = entry;
      } else {
        if (lowest.getValue().compareTo(entry.getValue()) < 0) {
          lowest = entry;
        }
      }
    }

    return (lowest != null) ? lowest.getKey() : -1;
  }

  private void splitLines() {
    // split lines
    try {
      BufferedReader br = new BufferedReader(new FileReader("./lorem.txt"));
      {
        int i = 0;
        Writer writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("./lorem-" + i++ + ".txt"), "utf-8"));
        int counter = 0;
        for (String line; (line = br.readLine()) != null; ) {
          if (counter >= 1000) {
            try {
              writer.append(line);
              writer.close();
              counter = 0;
            } catch (Exception e) {
              e.printStackTrace();
            }
            writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("./lorem-" + i++ + ".txt"), "utf-8"));
          } else {
            counter++;
            try {
              writer.append(line).append('\n');
            } catch (Exception e) {
              e.printStackTrace();
              break;
            }
          }

        }
        try {
          writer.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void sortEachFile() throws IOException {
    Writer writer = null;
    for (int i = 0; i < 10; i++) {
      Path in = Paths.get(".", "lorem-" + i + ".txt");
      List<String> lines = Files.readAllLines(in);

      Comparator<String> comparator = new Comparator<String>() {
        @Override
        public int compare(String left, String right) {
          return right.compareTo(left);
        }
      };
      lines.sort(comparator);

      try {
        writer = new BufferedWriter(new OutputStreamWriter(
            new FileOutputStream("out-" + i + ".txt"), "utf-8"));
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

}
