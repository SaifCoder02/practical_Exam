package people;

import enums.BloodType;
import hospital.Room;
import hospital.Treatment;

public class Patient extends Person {

    private String disease; //
    final private BloodType bloodType;
    private Doctor doctor;
    private Nurse nurse;
    private Room room;
    private static int counter = 0;
    private Treatment patientTreatment;

    public Patient(String name, int age, String disease, BloodType bloodType) {
        super(name, age);
        this.disease = disease;
        this.bloodType = bloodType;
    }

    public Treatment getPatientTreatment() {
        return patientTreatment;
    }


    public void setPatientTreatment(Treatment patientTreatment) {
        this.patientTreatment = patientTreatment;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }


    public void setTreatingDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Doctor getTreatingDoctor() {
        return doctor;
    }

    public void setTreatingNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Nurse getTreatingNurse() {
        return nurse;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Room getRoom() {
        return room;
    }


    @Override
    public String toString() {
        return "people.Patient{" +
                "name='" + getName() + '\'' +
                ", age= " + getAge() +
                ", ID= " + getID() +
                ", disease= " + disease +
                ", bloodType= " + bloodType +
                '}';
    }
}

