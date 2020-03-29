package main.java.com.oop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        List<Integer> otherNumbers = new ArrayList<>();

        otherNumbers.add(10);
        otherNumbers.add(20);
        otherNumbers.add(30);

        printList(otherNumbers);
    }

    static void printList(Iterable<Integer> list){
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }

        Iterator iter = list.iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
