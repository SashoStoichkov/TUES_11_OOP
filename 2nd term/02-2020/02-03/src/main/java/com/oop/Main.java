package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Skara s = new Skara();

        List<IBakeable> cookies = new ArrayList<IBakeable>();
//        cookies.add(new Cookie("Pesho"));
//        cookies.add(new Cookie("Gosho"));
//        cookies.add(new Cookie("Tosho"));
//        cookies.add(new Steak());

        Scanner scan = new Scanner(System.in);
        Cookie newCookie = new Cookie(scan.nextLine());
        cookies.add(newCookie);
        s.bake(cookies);

//        Food f = (Food)cookies.get(2);
//        f.print_nutritional_value();
    }
}
