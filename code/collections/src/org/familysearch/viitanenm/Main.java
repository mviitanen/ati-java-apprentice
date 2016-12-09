package org.familysearch.viitanenm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  private final int MAX_ADDITIONS = 100000;
  private final int REMOVE_INDEX = 7777;

  public static void main(String[] args) {
    new Main().doIt();
  }

  private void doIt() {
    List<Integer> list = new ArrayList<Integer>();
    System.out.println("ArrayList");
    long delta = add(list);
    System.out.println(delta);
    delta = remove(list, REMOVE_INDEX);
    System.out.println(delta);
    delta = find(list, REMOVE_INDEX);
    System.out.println(delta);
    delta = clearAll(list, REMOVE_INDEX);
    System.out.println(delta);

    List<Integer> linkedList = new LinkedList<Integer>();
    System.out.println("Linkedlist");
    delta = add(linkedList);
    System.out.println(delta);
    delta = remove(linkedList, REMOVE_INDEX);
    System.out.println(delta);
    delta = find(linkedList, REMOVE_INDEX);
    System.out.println(delta);
    delta = clearAll(linkedList, REMOVE_INDEX);
    System.out.println(delta);

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    System.out.println("HashMap");
    delta = add(map);
    System.out.println(delta);
    delta = remove(map, REMOVE_INDEX);
    System.out.println(delta);
    delta = find(map, REMOVE_INDEX);
    System.out.println(delta);
    delta = clearAll(map, REMOVE_INDEX);
    System.out.println(delta);

    Set<Integer> set = new HashSet<Integer>();
    System.out.println("HashSet");
    delta = add(set);
    System.out.println(delta);
    delta = remove(set, REMOVE_INDEX);
    System.out.println(delta);
    delta = find(set, REMOVE_INDEX);
    System.out.println(delta);
    delta = clearAll(set, REMOVE_INDEX);
    System.out.println(delta);

    Set<Integer> treeSet = new TreeSet<Integer>();
    System.out.println("TreeSet");
    delta = add(treeSet);
    System.out.println(delta);
    delta = remove(treeSet, REMOVE_INDEX);
    System.out.println(delta);
    delta = find(treeSet, REMOVE_INDEX);
    System.out.println(delta);
    delta = clearAll(treeSet, REMOVE_INDEX);
    System.out.println(delta);
  }

  private long add(Collection collection) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX_ADDITIONS; i++) {
      collection.add(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long remove(Collection collection, int index) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX_ADDITIONS; i = i + 10) {
      collection.remove(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long find(Collection collection, int index) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX_ADDITIONS; i = i + 10) {
      collection.contains(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long clearAll(Collection collection, int index) {
    long start = System.currentTimeMillis();
    collection.clear();
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long add(Map map) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < 10000; i++) {
      map.put(i, i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long remove(Map map, int index) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX_ADDITIONS; i = i + 10) {
      map.remove(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long find(Map map, int index) {
    long start = System.currentTimeMillis();
    for (int i = 0; i < MAX_ADDITIONS; i = i + 10) {
      map.containsKey(i);
    }
    long end = System.currentTimeMillis();
    return end - start;
  }

  private long clearAll(Map map, int index) {
    long start = System.currentTimeMillis();
    map.clear();
    long end = System.currentTimeMillis();
    return end - start;
  }
}