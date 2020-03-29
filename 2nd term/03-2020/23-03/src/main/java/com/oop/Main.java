package main.java.com.oop;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Temple> templeList = new ArrayList<>();
        List<Temple> templeList1 = new LinkedList<>();

        Set<Temple> templeSet = new HashSet<>();
        Set<Temple> templeSet1 = new TreeSet<>();

        Map<String, Temple> templeMap = new HashMap<>();
        Map<String, Temple> templeMap1 = new TreeMap<>();

        templeList.add(new Temple("SaintMario", "Mario", 1, true));
        templeList.add(new Temple("SaintMario", "Mario", 1, true));
        templeList.add(new Temple("SaintMario", "Mario", 1, true));
        templeList.add(new Temple("SaintMario", "Mario", 1, true));

        templeList1.add(new Temple("SaintMario", "Mario", 1, true));
        templeList1.add(new Temple("SaintMario", "Mario", 1, true));
        templeList1.add(new Temple("SaintMario", "Mario", 1, true));
        templeList1.add(new Temple("SaintMario", "Mario", 1, true));

        System.out.println("==============");
        printList(templeList);
        System.out.println("==============");
        printList(templeList1);
    }

    static void printList(Iterable list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
