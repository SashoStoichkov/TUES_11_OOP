package main.java.com.oop;

public class MedSister {
    private final String firstName;
    private final String lastName;
    private final Integer yearsExperience;

    public MedSister(String firstName, String lastName, Integer yearsExperience) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearsExperience = yearsExperience;
    }

    public Integer getYearsExperience() {
        return yearsExperience;
    }

    @Override
    public String toString() {
        return "MedSister " + firstName + " " + lastName;
    }

    public void putVaccine(String visitationDate, PatientProfile patientProfile, Vaccine vaccine) throws DiseaseException {
        Visitation visitation = new Visitation(visitationDate);
        patientProfile.addVisitation(visitation);

        System.out.println("\n============");
        System.out.println("Visititation info:");
        System.out.println(this.toString());
        System.out.println("Patient: " + patientProfile.getPatient().getFullName());
        System.out.println("Date: " + visitation.getDate());
        System.out.println("MedSister put vaccine against: " + vaccine);
    }
}
