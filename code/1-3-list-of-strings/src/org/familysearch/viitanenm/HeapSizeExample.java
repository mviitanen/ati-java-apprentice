package org.familysearch.viitanenm;

import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ManagementFactory;

/**
 * Created by viitanenm on 1/3/17.
 */
public class HeapSizeExample {

  public static void main(String[] args){
    Runtime rt = Runtime.getRuntime();
    long totMem = rt.totalMemory();
    long freeMem = rt.freeMemory();
    long physicalMem = ((OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();

    System.out.printf("%-10s %11s %sMB\n", "Total:", totMem, totMem/1024/1024);
    System.out.printf("%-10s %11s %sMB\n", "Free:", freeMem, freeMem/1024/1024);
    System.out.printf("%-10s %11s %sMB\n", "Diff:", (totMem - freeMem), (totMem - freeMem)/1024/1024);
    System.out.printf("%-10s %11s %sMB\n", "Physical:", physicalMem, physicalMem/1024/1024);



  }
}
