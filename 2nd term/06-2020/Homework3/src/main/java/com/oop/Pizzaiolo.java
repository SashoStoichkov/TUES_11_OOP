package main.java.com.oop;

import main.java.com.oop.exceptions.InvalidYearsExperienceException;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class Pizzaiolo implements Runnable {
    private final Pizzeria pizzeria;
    private final String firstName;
    private final String lastName;
    private final Integer yearsExperience;
    private final Double timeForPreparation;

    public Pizzaiolo(Pizzeria pizzeria, String firstName, String lastName, Integer yearsExperience) throws InvalidYearsExperienceException {
        this.pizzeria = pizzeria;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;

        if (0 <= yearsExperience && yearsExperience <= 3) {
            this.timeForPreparation = 1.0;
        } else if (4 <= yearsExperience && yearsExperience <= 8) {
            this.timeForPreparation = 0.5;
        } else if (9 <= yearsExperience) {
            this.timeForPreparation = 0.3;
        } else {
            throw new InvalidYearsExperienceException();
        }
    }

    @Override
    public String toString() {
        return "Pizzaiolo{ " + firstName + " " + lastName + " " + yearsExperience + " }";
    }

    @Override
    public void run() {
        while (true) {
            try {
                Order forPreparation = pizzeria.getOrdersForPreparation().take();

                String date = String.valueOf(new Timestamp(new Date().getTime()));
                pizzeria.log(date + " | " + this + " starting to prepare " + forPreparation);

                Thread.sleep((long) (timeForPreparation(forPreparation.getIngredients().size()) * 1000));

                date = String.valueOf(new Timestamp(new Date().getTime()));
                pizzeria.log(date + " | " + this + " prepared " + forPreparation + " for baking! TO THE STOVE!");

                pizzeria.getOrdersForBaking().put(forPreparation);
            } catch (InterruptedException | IOException e) {
                break;
            }
        }
    }

    private Double timeForPreparation(Integer ingredients) {
        return ingredients * timeForPreparation;
    }
}
