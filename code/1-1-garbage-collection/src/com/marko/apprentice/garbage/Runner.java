package com.marko.apprentice.garbage;

import com.marko.apprentice.garbage.GarbageCollectorDemonstration;

/**
 * Runs the demonstration for garbage collection
 */
public class Runner {
  public static void main(String[] args){
    GarbageCollectorDemonstration demo = new GarbageCollectorDemonstration();
    demo.makeObjects();
  }
}
