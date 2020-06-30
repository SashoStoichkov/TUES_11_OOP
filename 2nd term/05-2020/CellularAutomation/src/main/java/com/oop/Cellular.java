package main.java.com.oop;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cellular {
    public interface IOnEnd {
        void exit();
    }

    private final Map<List<Boolean>, Boolean> ruleSet;
    private List<Character> previousField;

    public Cellular(Map<List<Boolean>, Boolean> ruleSet, List<Character> startingField) {
        this.ruleSet = ruleSet;
        this.previousField = startingField;
    }

    private Boolean characterToBoolean(Character value) {
        return switch (value) {
            case '1' -> true;
            case '0' -> false;
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

    private Character booleanToCharacter(Boolean value) {
        if (value) return '1';
        return '0';
    }

    private String listToString(List<Character> generation) {
        StringJoiner result = new StringJoiner(" ");

        generation.stream().map(Object::toString).forEach(result::add);

        return result.toString();
    }

    public void run(Integer iterations, IOnEnd onEnd) throws IllegalStateException {
        for (int i = 0; i < iterations; i++) {
            List<Boolean> previousFieldBoolean = previousField.stream()
                    .map(this::characterToBoolean)
                    .collect(Collectors.toList());

            List<Character> currentField = new ArrayList<>();

            IntStream.range(0, previousFieldBoolean.size())
                    .forEach(j -> {
                        Boolean left, element, right;

                        if (j == 0) left = previousFieldBoolean.get(previousFieldBoolean.size() - 1);
                        else left = previousFieldBoolean.get(j - 1);

                        element = previousFieldBoolean.get(j);

                        if (j == previousFieldBoolean.size() - 1) right = previousFieldBoolean.get(0);
                        else right = previousFieldBoolean.get(j + 1);

                        List<Boolean> booleans = Arrays.asList(left, element, right);
                        if (ruleSet.containsKey(booleans)) currentField.add(booleanToCharacter(ruleSet.get(booleans)));
                    });

            System.out.print("Generation " + (i+1) + ": ");
            System.out.println(listToString(currentField));

            previousField = currentField;
        }
        onEnd.exit();
    }
}
