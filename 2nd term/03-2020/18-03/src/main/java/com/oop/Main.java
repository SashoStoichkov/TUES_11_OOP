package main.java.com.oop;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws DiseaseException {
        Patient patient = new Patient("Pesho", "Peshov", "000000010");
        PatientProfile patientProfile = new PatientProfile(patient);

        HashSet<Symptom> symptomHashSet = new HashSet<>();
        symptomHashSet.add(Symptom.TEMP);
        symptomHashSet.add(Symptom.COUGH);
        symptomHashSet.add(Symptom.DIFFICULT_BREATHING);

        Doctor doctor = new Doctor("Gosho", "Goshev", 10);
        MedSister medSister = new MedSister("Maria", "Marieva", 5);

        MedOffice medOffice = new MedOffice(doctor, medSister);
        medOffice.addPatientProfile(patientProfile);

        doctor.diagnose("01-01-2020", patientProfile, symptomHashSet);
        medSister.putVaccine("03-01-2020", patientProfile, Vaccine.TETANUS);

        System.out.println();

        for (int i = 0; i < patientProfile.getVisitationList().size(); i++) {
            System.out.println(patientProfile.getVisitationList().get(i));
        }

        System.out.println();

        Patient patient1 = new Patient("Alex", "Alexov", "000000001");
        PatientProfile patientProfile1 = new PatientProfile(patient1);

        Patient patient2 = new Patient("Alex", "Alex", "000000100");
        PatientProfile patientProfile2 = new PatientProfile(patient2);

        doctor.diagnose("02-01-2020", patientProfile2, symptomHashSet);

        System.out.println();

        medOffice.addPatientProfile(patientProfile2);
        medOffice.addPatientProfile(patientProfile1);

        System.out.println("All patientProfiles:");

        for (PatientProfile profile : medOffice.getPatientProfiles()) {
            System.out.println(profile);
        }

        medOffice.sortPatientProfilesByName();

        medOffice.sortPatientProfilesByEGN();

        medOffice.sortPatientProfilesByNumberVisitations();
    }
}
