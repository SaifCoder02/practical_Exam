package hospital;

import enums.HospitalDepartments;
import people.Doctor;
import people.Nurse;
import people.Patient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HospitalServices {
    private static List<Patient> patients = new ArrayList<>();
    private List<Doctor> doctors = new ArrayList<>();
    private List<Nurse> nurses = new ArrayList<>();
    private List<Room> rooms = new ArrayList<>();

    public Ticket bookTicket(Patient patient , HospitalDepartments hospitalDepartment) {
        return new Ticket(LocalDate.now()+"" , hospitalDepartment , patient);
    }
    public Patient searchForPatient(int patientID) {
        for (Patient patient : HospitalServices.getPatients()) {
            if (patient.getID() == patientID) {
                return patient;
            }
        }
        return null;
    }

    public static List<Patient> getPatients() {
        return patients;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public List<Nurse> getNurses() {
        return nurses;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
        System.out.println("The patient is added successfully and your ID is : "+patient.getID());
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
        System.out.println("The doctor is added successfully\n");
    }

    public void addNurse(Nurse nurse) {
        nurses.add(nurse);
        System.out.println("The nurse is added successfully\n");

    }

    public void addRoom(Room room) {
        rooms.add(room);
        System.out.println("The room is added successfully\n");

    }

    public void removePatient(int pID) {
        if (patients.isEmpty())
            System.out.println("No patients to be removed");
        else {
            for (Patient patient : patients) {
                if (patient.getID() == pID) {
                    patients.remove(patient);
                    System.out.println("people.Patient is removed successfully");
                    return;
                }
            }
            System.out.println("There is no patient with this ID");
        }
    }

    public void removeDoctor(int dID) {
        if (doctors.isEmpty())
            System.out.println("No doctors to be removed");
        else {
            for (Doctor doctor : doctors) {
                if (doctor.getID() == dID) {
                    doctors.remove(doctor);
                    System.out.println("people.Doctor is removed successfully");
                    return;
                }
            }
            System.out.println("There is no doctor with this ID");
        }
    }

    public void removeNurse(int nID) {
        if (nurses.isEmpty())
            System.out.println("No nurses to be removed");
        else {
            for (Nurse nurse : nurses) {
                if (nurse.getID() == nID) {
                    nurses.remove(nurse);
                    System.out.println("people.Nurse is removed successfully");
                    return;
                }
            }
            System.out.println("There is no nurse with this ID");
        }
    }

    public void removeRoom(int rNum) {
        if (rooms.isEmpty())
            System.out.println("No rooms to be removed");
        else {
            for (Room room : rooms) {
                if (room.getNumber() == rNum) {
                    rooms.remove(room);
                    System.out.println("hospital.Room is removed successfully");
                    return;
                }
            }
            System.out.println("There is no rooms with this number");
        }
    }

    public Patient findPatient(int patientID) {
        for (Patient patient : patients) {
            if (patient.getID() == patientID) {
                return patient;
            }
        }
        return null;
    }

    public Doctor findDoctor(int doctorID) {
        for (Doctor doctor : doctors) {
            if (doctor.getID() == doctorID) {
                return doctor;
            }
        }
        return null;
    }

    public Nurse findNurse(int nurseID) {
        for (Nurse nurse : nurses) {
            if (nurse.getID() == nurseID) {
                return nurse;
            }
        }
        return null;
    }

    public Room findRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void assignDoctorToPatient(int patientID, int doctorID) {
        Patient patient = findPatient(patientID);
        Doctor doctor = findDoctor(doctorID);

        if (patient != null && doctor != null) {
            patient.setTreatingDoctor(doctor);
            System.out.println("The doctor is assigned to the patient successfully");
            doctor.addPatientToList(patient);
        } else
            System.out.println("people.Patient or doctor not found with the given IDs");
    }

    public void assignNurseToPatient(int patientID, int nurseID) {
        Patient patient = findPatient(patientID);
        Nurse nurse = findNurse(nurseID);

        if (patient != null && nurse != null) {
            patient.setTreatingNurse(nurse);
            System.out.println("The nurse is assigned to the patient successfully");
            nurse.addPatientToList(patient);
        } else
            System.out.println("people.Patient or nurse not found with the given IDs");
    }

    public void assignRoomToPatient(int patientID, int roomNumber) {
        Patient patient = findPatient(patientID);
        Room room = findRoom(roomNumber);

        if (patient != null && room != null) {
            if(room.getCapacity() != 0) {
                patient.setRoom(room);
                System.out.println("The room is assigned to the patient successfully");
                room.addPatientToRoom(patient);
            }
            else
                System.out.println("There is no free places in this room\n");
        } else
            System.out.println("people.Patient or room not found with the given IDs");
    }

    public void getAllPatientInfo(Integer pID) {
        if (patients.isEmpty())
            System.out.println("No patients to be viewed");
        else {
            System.out.println("Enter ID of the patient: ");
            Patient patient = findPatient(pID);

            if (patient != null) {
                Doctor doctor = patient.getTreatingDoctor();
                Nurse nurse = patient.getTreatingNurse();
                Room room = patient.getRoom();
                System.out.println("people.Patient Information: \n" + patient.toString());


                    if (doctor != null && doctors.contains(doctor))
                    System.out.println("\nTreating people.Doctor Information:\n" + doctor.toString());
                else
                    System.out.println("\nNo treating doctor assigned to this patient");

                if (nurse != null && nurses.contains(nurse))
                    System.out.println("\nTreating people.Nurse Information:\n" + nurse.toString());
                else
                    System.out.println("\nNo treating nurse assigned to this patient");

                if (room != null && rooms.contains(room))
                    System.out.println("\nhospital.Room Information:\n" + room.toString());
                else
                    System.out.println("\nNo room assigned to this patient");
            } else
                System.out.println("No patient exists with this ID");

        }
    }

    public void getPatientInfo(Integer pID) {
        if (patients.isEmpty())
            System.out.println("No patients to be viewed");
        else {
            System.out.println("Enter ID of the patient: ");
            for (Patient patient : patients) {
                if (patient.getID() == pID) {
                    System.out.println(patient.toString());
                    return;
                }
            }
            System.out.println("No patient exist with this ID");
        }
    }

    public void getDoctorInfo(Integer dID) {
        if (doctors.isEmpty())
            System.out.println("No doctors to be viewed");
        else {
            System.out.println("Enter ID of the doctor: ");
            for (Doctor doctor : doctors) {
                if (doctor.getID() == dID) {
                    System.out.println(doctor);
                    return;
                }
            }
            System.out.println("No doctor exist with this ID");
        }
    }

    public void getNurseInfo(Integer nID) {
        if (nurses.isEmpty())
            System.out.println("No nurse to be viewed");
        else {
            System.out.println("Enter ID of the nurse: ");
            //System.out.println("Doctors in hospital");
            for (Nurse nurse : nurses) {
                if (nurse.getID() == nID) {
                    System.out.println(nurse.toString());
                    return;
                }
            }
            System.out.println("No nurse exist with this ID");
        }

    }

    public void getRoomInfo(Integer roomNumber) {
        if (rooms.isEmpty())
            System.out.println("No rooms to be viewed");
        else {
            System.out.println("Enter number of the room: ");
            //System.out.println("Doctors in hospital");
            for (Room room : rooms) {
                if (room.getNumber() == roomNumber) {
                    System.out.println(room.toString());
                    return;
                }
            }
            System.out.println("No room exist with this ID");
        }

    }

    public void getAllPatientsInfo() {
        if (patients.isEmpty())
            System.out.println("No patients to be viewed");
        else {
            System.out.println("Patients in hospital:");
            for (Patient patient : patients) {
                System.out.println(patient.toString());
            }
        }
    }

    public void getAllDoctorsInfo() {
        if (doctors.isEmpty())
            System.out.println("No doctors to be viewed");
        else {
            System.out.println("Doctors in hospital:");
            for (Doctor doctor : doctors) {
                System.out.println(doctor.toString());
            }
        }

    }

    public void getAllNursesInfo() {
        if (nurses.isEmpty())
            System.out.println("No nurses to be viewed");
        else {
            System.out.println("nurses in hospital:");
            for (Nurse nurse : nurses) {
                System.out.println(nurse.toString());
            }
        }
    }

    public void getAllRoomsInfo() {
        if (rooms.isEmpty())
            System.out.println("No rooms to be viewed");
        else {
            System.out.println("rooms in hospital");
            for (Room room : rooms) {
                System.out.println(room.toString());
            }
        }
    }

}
