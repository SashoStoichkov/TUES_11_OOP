package main.java.com.oop;

import main.java.com.oop.exceptions.*;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Pizzeria pizzeria = new Pizzeria();

        while (true) {
            String input;

            try {
                input = scanner.nextLine();
            } catch (NoSuchElementException e) {
                pizzeria.shutDown();
                break;
            }

            List<String> inputList = Arrays.asList(input.split(", "));

            try {
                switch (inputList.get(0)) {
                    case "HirePizzaMan" -> {
                        String firstName = inputList.get(1);
                        String lastName = inputList.get(2);
                        Integer yearsExperience = Integer.parseInt(inputList.get(3));

                        try {
                            pizzeria.addPizzaiolo(new Pizzaiolo(pizzeria, firstName, lastName, yearsExperience));
                        } catch (InvalidYearsExperienceException e) {
                            System.out.println(e.getMessage());
                        }
                    } case "Stove" -> {
                        Integer capacity = Integer.parseInt(inputList.get(1));

                        pizzeria.addStoves(new Stoves(pizzeria, capacity));
                    } case "Ingredient" -> {
                        String ingredientName = inputList.get(1);
                        try {
                            IngredientType ingredientType = IngredientType.valueOf(inputList.get(2));

                            try {
                                if (!pizzeria.getIngredientMap().containsKey(ingredientName)) {
                                    try {
                                        pizzeria.addIngredient(ingredientName, ingredientType);
                                    } catch (InvalidIngredientTypeException e) {
                                        System.out.println(e.getMessage());
                                    }
                                } else {
                                    throw new IngredientAlreadyExistsException();
                                }
                            } catch (IngredientAlreadyExistsException e) {
                                System.out.println(e.getMessage());
                            }
                        } catch (IllegalArgumentException e) {
                            System.out.println("No such IngredientType!");
                        }
                    } case "Order" -> {
                        Integer id = Integer.parseInt(inputList.get(1));
                        try {
                            List<Ingredient> ingredients = IntStream.range(2, inputList.size()).mapToObj(i -> pizzeria.getIngredientMap().get(inputList.get(i))).collect(Collectors.toList());

                            try {
                                pizzeria.addOrder(new Order(id, ingredients));
                            } catch (RequirementsNotMetException e) {
                                System.out.println(e.getMessage());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } catch (NullPointerException e) {
                            System.out.println("Ingredient/s not in pizzeria!");
                        }
                    }
                    default -> throw new IllegalStateException("Unexpected value: '" + inputList.get(0) + "'! Possible options are:\n'HirePizzaMan'; 'Stove'; 'Ingredient'; 'Order'");
                }
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
