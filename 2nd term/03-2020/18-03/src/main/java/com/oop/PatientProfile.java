package main.java.com.oop;

import java.util.ArrayList;
import java.util.List;

public class PatientProfile {
    private final Patient patient;
    private List<Visitation> visitationList;

    public PatientProfile(Patient patient) {
        this.patient = patient;
        visitationList = new ArrayList<>();
    }

    public Patient getPatient() {
        return patient;
    }

    public List<Visitation> getVisitationList() {
        return visitationList;
    }

    public void addVisitation(Visitation visitation) {
        this.visitationList.add(visitation);
    }

    @Override
    public String toString() {
        return "PatientProfile{" +
                "patient=" + patient.toString() +
                ", numberVisitations=" + visitationList.size() +
                '}';
    }
}
