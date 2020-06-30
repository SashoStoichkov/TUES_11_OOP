package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
//    Извинявам се, че не се справих с тази задача :(
//    Това е една тотална излагация, за която наистина съжалявам

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        List<Resource> resources = new ArrayList<>();
        List<Resource> workers = new ArrayList<>();

        while (true) {
            input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            } else {
                String[] tokens = input.split(",");
                resources.add(new Resource(new Position(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1])), Integer.parseInt(tokens[2])));
            }
        }

//        too long
//        while (true) {
//            input = scanner.nextLine();
//            if (input.equals("stop")) {
//                break;
//            } else {
//                String[] tokens = input.split(",");
//                workers.add(new Worker(tokens[0], Integer.parseInt(tokens[1]), new Position(Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3])), Integer));
//            }
//        }
    }
}
