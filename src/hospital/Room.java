package hospital;

import people.Patient;

import java.util.ArrayList;
import java.util.List;

public class  Room {
    private Integer capacity;
    private Integer number;
    private String status;
    private List<Patient> patientsInRoom = new ArrayList<>();


    public Room(Integer number, Integer capacity, String status) {
        this.capacity = capacity;
        this.number = number;
        this.status = status;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getStatus() {
        return status;
    }

    public List<Patient> getPatientsInRoom() {
        return patientsInRoom;
    }

    public Integer getNumber() {
        return number;
    }


    public void addPatientToRoom(Patient patient) {
        if (capacity != 0) {
            patientsInRoom.add(patient);
            capacity--;
        } else
            System.out.println("There is no free places in this room");

    }

    public void showPatientsInRoom() {
        for (Patient patient : patientsInRoom) {
            System.out.println(patient);
        }
    }


    @Override
    public String toString() {
        return "hospital.Room{" +
                "Number= " + number +
                ", capacity= " + capacity +
                ", statue='" + status + '\'' +
                '}';
    }
}
