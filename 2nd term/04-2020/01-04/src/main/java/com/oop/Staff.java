package main.java.com.oop;

public class Staff {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private Qualification qualification;
    private static Integer numberStaff = 0;

    public Staff(String firstName, String lastName, Qualification qualification) {
        this.id = numberStaff;
        this.firstName = firstName;
        this.lastName = lastName;
        this.qualification = qualification;
        numberStaff++;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", qualification=" + qualification +
                '}';
    }
}
