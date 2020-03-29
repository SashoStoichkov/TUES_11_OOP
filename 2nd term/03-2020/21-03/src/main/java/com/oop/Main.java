package main.java.com.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = "";
        ArrayList<Squirrel> squirrels = new ArrayList<>();
        boolean stopped = false;

        while (true) {
            input = scanner.nextLine();
            if (input.equals("stop")) {
                break;
            } else {
                String[] tokens = input.split(",");
                squirrels.add(new Squirrel(tokens[0], tokens[1], Integer.parseInt(tokens[2])));
            }
        }

        while (!stopped) {
            while (true) {
                for (Squirrel squirrel : squirrels) {
                    while (squirrel.getFoodFound() <= squirrel.getMaxFoodPerYear()) {
                        input = scanner.nextLine();

                        if (input.equals("stop")) {
                            stopped = true;
                            break;
                        } else {
                            try {
                                String[] tokens = input.split(" ");
                                switch (tokens[0]) {
                                    case "nuts":
                                        squirrel.addFood(new Nuts(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                                        break;

                                    case "mcburger":
                                        squirrel.addFood(new McBurger(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                                        break;

                                    case "cake":
                                        squirrel.addFood(new Cake(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2])));
                                        break;

                                    default:
                                        throw new UnknownFoodException();
                                }
                            } catch (NoMoreFoodException e) {
                                break;
                            } catch (UnknownFoodException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }

                    if (stopped) {
                        break;
                    }
                }

                if (stopped) {
                    break;
                } else {
                    for (Squirrel squirrel : squirrels) {
                        squirrel.passWinter();
                        System.out.println(squirrel + " " + squirrel.getBurrowString());
                    }
                }
            }
        }

        for (Squirrel squirrel : squirrels) {
            System.out.println(squirrel + " " + squirrel.getBurrowString());
        }
    }
}
