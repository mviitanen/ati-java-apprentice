package org.familysearch.viitanenm.gc;

import com.javamex.classmexer.MemoryUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates objects to cause garbage collection
 */
public class GarbageCollectionExample {
  private final static String SHORT_STRING = "short";
  private final static String LONG_STRING = "long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long long ";
  private final int WAIT_TIME_IN_MS = 0;
  private final int NUMBER_OF_OBJECTS = 306487100;

  private long totalMemoryPrevious;
  private long totalObjectMemoryPrevious;

  public GarbageCollectionExample() {

  }

  public static void main(String[] args) {
    new GarbageCollectionExample().makeObjects();
  }

  public void makeObjects() {
    List<String> listOfStrings = new ArrayList<String>(0);
    for (int i = 1; i <= NUMBER_OF_OBJECTS; i++) {
      listOfStrings.add("short");
      try {
        // sleep to make it slower so I can inspect it
        Thread.sleep(WAIT_TIME_IN_MS);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

     /* if(i%100==0){

        long totalMemory = Runtime.getRuntime().totalMemory();
        long totalObjectMemory = MemoryUtil.memoryUsageOf(listOfStrings);
        long totalMemoryDelta = totalMemory - totalMemoryPrevious;
        long totalObjectMemoryDelta = totalObjectMemory - totalObjectMemoryPrevious;

        System.out.println(i +" Strings in the list. Total memory: " + totalMemory +" increased by " + totalMemoryDelta +". Object memory " + totalObjectMemory +" increased by " + totalObjectMemoryDelta +" (list.size()=" + listOfStrings.size());
        totalMemoryPrevious = totalMemory;
        totalObjectMemoryPrevious = totalObjectMemory;



      }
*/

      if (i % 10000 == 0) {
        listOfStrings.clear();
        long totalMemory = Runtime.getRuntime().totalMemory();
        long totalObjectMemory = MemoryUtil.memoryUsageOf(listOfStrings);
        long totalMemoryDelta = totalMemory - totalMemoryPrevious;
        long totalObjectMemoryDelta = totalObjectMemory - totalObjectMemoryPrevious;

        System.out.println(i + " Strings in the list. Total memory: " + totalMemory + " increased by " + totalMemoryDelta + ". Object memory " + totalObjectMemory + " increased by " + totalObjectMemoryDelta + " (list.size()=" + listOfStrings.size());
        totalMemoryPrevious = totalMemory;
        totalObjectMemoryPrevious = totalObjectMemory;

      }
    }

    listOfStrings = new ArrayList<String>();
    // sleep so we can see objects go away
    for (int i = 0; i < 60; i++) {
      try {
        // sleep to make it slower so I can inspect it
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
