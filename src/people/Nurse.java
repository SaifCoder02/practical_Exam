package people;

import java.util.ArrayList;
import java.util.List;

public class Nurse extends Person {

    private List<Patient> patientsOfNurse = new ArrayList<>();

    private String Department;
    private static int counter = 0;

    public Nurse(String name, int age, String department) {
        super(name, age);
        Department = department;
    }

    public void addPatientToList(Patient patient) {
        patientsOfNurse.add(patient);
    }

    public void showPatientsOfNurse() {
        if (patientsOfNurse.isEmpty()) {
            System.out.println("This nurse does not treat any patients");
        } else {
            for (Patient patient : patientsOfNurse) {
                System.out.println(patient);
            }
        }
    }

    @Override
    public String toString() {
        return "people.Nurse{" +
                "name='" + getName() + '\'' +
                ", Department='" + Department + '\'' +
                ", age= " + getAge() +
                ", ID= " + getID() +
                '}';
    }
}
