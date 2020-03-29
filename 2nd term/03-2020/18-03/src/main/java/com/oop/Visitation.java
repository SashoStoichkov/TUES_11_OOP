package main.java.com.oop;

import java.util.*;

public class Visitation {
    private final String date;
    private HashSet<Symptom> symptomHashSet;
    private Prescription prescription;
    private List<HashSet<Symptom>> possibleSymptomHashSets;


    public Visitation(String date) throws DiseaseException {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public HashSet<Symptom> getSymptomHashSet() {
        return symptomHashSet;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setSymptomHashSet(HashSet<Symptom> symptomHashSet) {
        this.symptomHashSet = symptomHashSet;
    }

    public void setPossibleSymptomHashSets() throws DiseaseException {
        List<HashSet<Symptom>> possibleSymptomHashSets = new ArrayList<>();

        Disease covid_19 = new Disease("COVID_19");
        Disease cold = new Disease("COLD");
        Disease fatigue = new Disease("FATIGUE");

        possibleSymptomHashSets.add(covid_19.getSymptomHashSet());
        possibleSymptomHashSets.add(cold.getSymptomHashSet());
        possibleSymptomHashSets.add(fatigue.getSymptomHashSet());

        this.possibleSymptomHashSets = possibleSymptomHashSets;
    }

    public void setPrescription() {
        if (this.symptomHashSet.equals(possibleSymptomHashSets.get(0))) {
            this.prescription = Prescription.QUARANTINE;
        } else if (this.symptomHashSet.equals(possibleSymptomHashSets.get(1))) {
            this.prescription = Prescription.COLDREX;
        } else if (this.symptomHashSet.equals(possibleSymptomHashSets.get(2))) {
            this.prescription = Prescription.STAY_HOME;
        }
    }

    public String setDisease() {
        String resultDisease = "";

        if (this.symptomHashSet.equals(possibleSymptomHashSets.get(0))) {
            resultDisease = "COVID_19";
        } else if (this.symptomHashSet.equals(possibleSymptomHashSets.get(1))) {
            resultDisease = "COLD";
        } else if (this.symptomHashSet.equals(possibleSymptomHashSets.get(2))) {
            resultDisease = "FATIGUE";
        }

        return resultDisease;
    }

    @Override
    public String toString() {
        return "Visitation{" +
                "date='" + date + '\'' +
                '}';
    }
}
