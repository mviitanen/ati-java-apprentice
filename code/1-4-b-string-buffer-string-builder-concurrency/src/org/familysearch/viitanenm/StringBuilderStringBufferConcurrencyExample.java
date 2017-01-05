package org.familysearch.viitanenm;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StringBuilderStringBufferConcurrencyExample {
  private static StringBuffer buffer = new StringBuffer();
  private static StringBuilder builder = new StringBuilder();

  public static void main(String[] args) {
    new StringBuilderStringBufferConcurrencyExample().doIt();
  }

  private void doIt() {

    Collection<Callable<Object>> callables = new ArrayList<Callable<Object>>();
    ExecutorService execSvc = Executors.newCachedThreadPool();
    try {

      // create 2 threads of each
      for (int i = 0; i < 2; i++) {
        callables.add(new WriterThread("" + i, 10));
      }

      // Execute all threads and wait for them to finish
      List<Future<Object>> results = execSvc.invokeAll(callables);
      System.out.println("FUTURES:");
      for(Future f : results) {
        System.out.println(f);
      }
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      System.out.println("++++++++ REPORT +++++++");
      report();
    }
  }

  /**
   * Write results in a file
   */
  private void report() {
    Writer builderWriter = null;
    Writer bufferWriter = null;
    try {
      builderWriter = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("builder.txt")));

      System.out.println(builder.toString());
      builderWriter.write(builder.toString());

      bufferWriter = new BufferedWriter(new OutputStreamWriter(
          new FileOutputStream("buffer.txt")));

      System.out.println(buffer.toString());
      bufferWriter.write(buffer.toString());

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (builderWriter != null) {
        try {
          builderWriter.close();
          System.out.println("Closed builder");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      if (bufferWriter != null) {
        try {
          bufferWriter.close();
          System.out.println("Closed buffer");
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

  }

  /**
   * A Callable that writes into the buffer
   */
  class WriterThread implements Callable {
    private int max = 10;
    private String name = "";

    public WriterThread(String name, int max) {
      this.name = name;
      this.max = max;
    }

    @Override
    public Object call() throws Exception {
      for (int counter = 0; counter < this.max; counter++) {
        buffer.append("thread ").append(this.name).append(" -> ").append(counter).append("\n");
        builder.append("thread ").append(this.name).append(" -> ").append(counter).append("\n");
        try {
          Thread.sleep(10);
        } catch (InterruptedException ignored) {
          ignored.printStackTrace();
        }
      }
      return null;
    }
  }

}