package main.java.com.oop;

import java.util.ArrayList;
import java.util.Collections;

public class MedOffice {
    private final Doctor doctor;
    private final MedSister medSister;
    private ArrayList<PatientProfile> patientProfiles = new ArrayList<>();

    public MedOffice(Doctor doctor, MedSister medSister) {
        this.doctor = doctor;
        this.medSister = medSister;
    }

    public ArrayList<PatientProfile> getPatientProfiles() {
        return patientProfiles;
    }

    public void addPatientProfile(PatientProfile patientProfile) {
        this.patientProfiles.add(patientProfile);
    }

    private PatientProfile getProfileByName(String name) {
        PatientProfile profile = null;

        for (PatientProfile patientProfile : this.patientProfiles) {
            if (patientProfile.getPatient().getFullName().equals(name)) {
                profile = patientProfile;
            }
        }

        return profile;
    }

    public void sortPatientProfilesByName() {
        ArrayList<String> patientProfilesNames = new ArrayList<>();

        for (PatientProfile patientProfile : this.patientProfiles) {
            patientProfilesNames.add(patientProfile.getPatient().getFullName());
        }

        Collections.sort(patientProfilesNames);

        System.out.println("\nAll patientProfiles sorted by name:");
        for (String patientName : patientProfilesNames) {
            System.out.println(getProfileByName(patientName));
        }
    }

    private PatientProfile getProfileByEGN(String EGN) {
        PatientProfile profile = null;

        for (PatientProfile patientProfile : this.patientProfiles) {
            if (patientProfile.getPatient().getEGN().equals(EGN)) {
                profile = patientProfile;
            }
        }

        return profile;
    }

    public void sortPatientProfilesByEGN() {
        ArrayList<String> patientProfilesEGNs = new ArrayList<>();

        for (PatientProfile patientProfile : this.patientProfiles) {
            patientProfilesEGNs.add(patientProfile.getPatient().getEGN());
        }

        Collections.sort(patientProfilesEGNs);

        System.out.println("\nAll patientProfiles sorted by EGN:");
        for (String patientEGN : patientProfilesEGNs) {
            System.out.println(getProfileByEGN(patientEGN));
        }
    }

    private PatientProfile getProfileByNumberVisitations(Integer numberVisitations) {
        PatientProfile profile = null;

        for (PatientProfile patientProfile : this.patientProfiles) {
            if (patientProfile.getVisitationList().size() == numberVisitations) {
                profile = patientProfile;
            }
        }

        return profile;
    }

    public void sortPatientProfilesByNumberVisitations() {
        ArrayList<Integer> patientProfilesVisitations = new ArrayList<>();

        for (PatientProfile patientProfile : this.patientProfiles) {
            patientProfilesVisitations.add(patientProfile.getVisitationList().size());
        }

        Collections.sort(patientProfilesVisitations);

        System.out.println("\nAll patientProfiles sorted by number of visitations:");
        for (Integer patientNumberVisitations : patientProfilesVisitations) {
            System.out.println(getProfileByNumberVisitations(patientNumberVisitations));
        }
    }
}
