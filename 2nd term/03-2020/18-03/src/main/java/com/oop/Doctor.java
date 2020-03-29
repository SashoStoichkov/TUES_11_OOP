package main.java.com.oop;

import java.util.HashSet;

public class Doctor {
    private final String firstName;
    private final String lastName;
    private final Integer yearsExperience;

    public Doctor(String firstName, String lastName, Integer yearsExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    @Override
    public String toString() {
        return "Doctor " + firstName + " " + lastName;
    }

    public void diagnose(String visitationDate, PatientProfile patientProfile, HashSet<Symptom> symptomHashSet) throws DiseaseException {
        Visitation visitation = new Visitation(visitationDate);
        visitation.setSymptomHashSet(symptomHashSet);
        visitation.setPossibleSymptomHashSets();
        visitation.setPrescription();

        patientProfile.addVisitation(visitation);

        System.out.println("\n============");
        System.out.println("Visititation info:");
        System.out.println(this.toString());
        System.out.println("Patient: " + patientProfile.getPatient().getFullName());
        System.out.println("Date: " + visitation.getDate());
        System.out.println("The patient came with these symptoms: " + visitation.getSymptomHashSet());
        System.out.println("Disease: " + visitation.setDisease());
        System.out.println("Prescription: " + visitation.getPrescription());
    }
}
