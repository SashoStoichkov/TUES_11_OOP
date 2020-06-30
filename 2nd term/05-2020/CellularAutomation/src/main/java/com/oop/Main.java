package main.java.com.oop;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Map<List<Boolean>, Boolean> ruleSet = setRules();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Number of generations: ");
        Integer generations = Integer.parseInt(scanner.nextLine());

        System.out.print("Starting field: ");
        String startingFieldString = scanner.nextLine();
        startingFieldString = startingFieldString.replaceAll(" ", "");

        List<Character> startingField = startingFieldString.chars()
                .mapToObj(character -> (char) character)
                .collect(Collectors.toList());

        Cellular cellular = new Cellular(ruleSet, startingField);
        try {
            cellular.run(generations, () -> System.out.println("The End"));
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<List<Boolean>, Boolean> setRules() {
        Map<List<Boolean>, Boolean> rules = new HashMap<>();

        Rule rule1 = new Rule(Arrays.asList(false, false, false), false);
        Rule rule2 = new Rule(Arrays.asList(false, false, true), true);
        Rule rule3 = new Rule(Arrays.asList(false, true, false), true);
        Rule rule4 = new Rule(Arrays.asList(false, true, true), true);
        Rule rule5 = new Rule(Arrays.asList(true, false, false), true);
        Rule rule6 = new Rule(Arrays.asList(true, false, true), false);
        Rule rule7 = new Rule(Arrays.asList(true, true, false), false);
        Rule rule8 = new Rule(Arrays.asList(true, true, true), false);

        rules.put(rule1.getElements(), rule1.getResult());
        rules.put(rule2.getElements(), rule2.getResult());
        rules.put(rule3.getElements(), rule3.getResult());
        rules.put(rule4.getElements(), rule4.getResult());
        rules.put(rule5.getElements(), rule5.getResult());
        rules.put(rule6.getElements(), rule6.getResult());
        rules.put(rule7.getElements(), rule7.getResult());
        rules.put(rule8.getElements(), rule8.getResult());

        return rules;
    }
}
