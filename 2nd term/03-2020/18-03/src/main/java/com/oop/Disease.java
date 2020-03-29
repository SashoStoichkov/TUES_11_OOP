package main.java.com.oop;

import java.util.HashSet;

public class Disease {
    private final String type;
    private HashSet<Symptom> symptomHashSet;
    private Prescription prescription;

    public Disease(String type) throws DiseaseException {
        this.type = type;
        setSymptomHashSet();
        setPrescription();
    }

    public HashSet<Symptom> getSymptomHashSet() {
        return symptomHashSet;
    }

    public void setSymptomHashSet() throws DiseaseException {
        HashSet<Symptom> symptomHashSet = new HashSet<>();

        switch (this.type) {
            case "COVID_19":
                symptomHashSet.add(Symptom.TEMP);
                symptomHashSet.add(Symptom.COUGH);
                symptomHashSet.add(Symptom.DIFFICULT_BREATHING);
                break;

            case "COLD":
                symptomHashSet.add(Symptom.TEMP);
                symptomHashSet.add(Symptom.COUGH);
                symptomHashSet.add(Symptom.VOMITING);
                break;

            case "FATIGUE":
                symptomHashSet.add(Symptom.HEADACHE);
                break;

            default:
                throw new DiseaseException();
        }

        this.symptomHashSet = symptomHashSet;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public void setPrescription() throws DiseaseException {
        switch (this.type) {
            case "COVID_19":
                this.prescription = Prescription.QUARANTINE;
                break;

            case "COLD":
                this.prescription = Prescription.COLDREX;
                break;

            case "FATIGUE":
                this.prescription = Prescription.STAY_HOME;
                break;

            default:
                throw new DiseaseException();
        }
    }
}
