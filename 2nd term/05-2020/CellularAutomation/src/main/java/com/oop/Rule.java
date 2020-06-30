package main.java.com.oop;

import java.util.List;
import java.util.Objects;

public class Rule {
    private final List<Boolean> elements;
    private final Boolean result;

    public Rule(List<Boolean> elements, Boolean result) {
        this.elements = elements;
        this.result = result;
    }

    public List<Boolean> getElements() {
        return elements;
    }

    public Boolean getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rule)) return false;
        Rule rule = (Rule) o;
        return elements.equals(rule.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash((Object) elements);
    }
}
