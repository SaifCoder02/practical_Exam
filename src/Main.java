
import enums.BloodType;
import people.Doctor;
import people.Nurse;
import people.Patient;

import java.util.Scanner;

public class Main {
    static void mainMenu() {
        System.out.println();
        System.out.println("1.Patient\n" +
                "2.Doctor\n" +
                "3.Nurse\n" +
                "4.hospital.Room\n" +
                "5.Exit\n");
        System.out.println();
    }

    static void patientMenu() {
        System.out.println();
        System.out.println("1.Add patient\n" +
                "2.Remove Patient\n" +
                "3.Assign doctor\n" +
                "4.Assign nurse\n" +
                "5.Assign room\n" +
                "6.View patient personal info\n" +
                "7.View patient info including the treating doctor,nurse and room\n" +
                "8.View all patients in the hospital\n" +
                "9.Exit\n");
        System.out.println();
    }

    static void doctorMenu() {
        System.out.println();
        System.out.println("1.Add doctor\n" +
                "2.Remove doctor\n" +
                "3.View doctor info\n" +
                "4.View patients who doctor is treating\n" +
                "5.View all doctors in the hospital\n" +
                "6.Exit\n");
        System.out.println();
    }

    static void nurseMenu() {
        System.out.println();
        System.out.println("1.Add nurse\n" +
                "2.Remove nurse\n" +
                "3.View Nurse info\n" +
                "4.View patients who nurse is caring\n" +
                "5.View all nurses in the hospital\n" +
                "6.Exit\n");
        System.out.println();
    }

    static void roomMenu() {
        System.out.println();
        System.out.println("1.Add room\n" +
                "2.Remove room\n" +
                "3.View room info\n" +
                "4.View patients who are in the room\n" +
                "5.View all rooms in the hospital\n" +
                "6.Exit\n");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Build the hospital :)
        hospital.HospitalServices hospitalServices = new hospital.HospitalServices();


        //Simple user interface
        while (true) {
            mainMenu();
            System.out.println("Enter option number: ");
            int choice = in.nextInt();
            in.nextLine();
            switch (choice) {
                case (1):
                    patientMenu();
                    System.out.println("Enter option number: ");
                    int PatientOption = in.nextInt();
                    in.nextLine();
                    switch (PatientOption) {
                        case (1):
                            System.out.println("Enter the patient name: ");
                            String name = in.nextLine();
                            System.out.println("Enter the patient age: ");
                            int age = in.nextInt();
                            in.nextLine();
                            System.out.println("Enther the disease: ");
                            String disease = in.nextLine();
                            System.out.println("Enter the patient blood type: ");
                            String bloodType = in.nextLine();
                            Patient patient = new Patient(name, age, disease, BloodType.AB_plus);
                            hospitalServices.addPatient(patient);
                            break;
                        case (2):
                            if (hospitalServices.getPatients().isEmpty()) {
                                System.out.println("There are no patients to be removed\n");
                            } else {
                                System.out.println("Enter ID for the patient that will be removed: ");
                                int removeID = in.nextInt();
                                hospitalServices.removePatient(removeID);
                            }
                            break;

                        case (3):
                            System.out.println("Enter patient ID: ");
                            int patientID = in.nextInt();
                            System.out.println("Enter treating doctor ID: ");
                            int doctorID = in.nextInt();
                            hospitalServices.assignDoctorToPatient(patientID, doctorID);
                            break;
                        case (4):
                            System.out.println("Enter patient ID: ");
                            int IDPatient = in.nextInt();
                            System.out.println("Enter caregiving nurse ID: ");
                            int nurseID = in.nextInt();
                            hospitalServices.assignNurseToPatient(IDPatient, nurseID);
                            break;
                        case (5):
                            System.out.println("Enter patient ID: ");
                            int IDofPatient = in.nextInt();
                            System.out.println("Enter the room number: ");
                            int roomNumber = in.nextInt();
                            hospitalServices.assignRoomToPatient(IDofPatient, roomNumber);
                            break;
                        case (6):
                            System.out.println("Enter ID of patient\n");
                            int pID = in.nextInt();
                            in.nextLine();
                            hospitalServices.getPatientInfo(pID);
                            break;
                        case (7):
                            hospitalServices.getAllPatientInfo(1000);
                            break;
                        case (8):
                            hospitalServices.getAllPatientsInfo();
                            break;
                        case (9):
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case (2):
                    doctorMenu();
                    System.out.println("Enter option number: ");
                    int doctorOption = in.nextInt();
                    in.nextLine();
                    switch (doctorOption) {
                        case (1):
                            System.out.println("Enter the doctor name: ");
                            String doctorName = in.nextLine();
                            System.out.println("Enter the doctor age: ");
                            int doctorAge = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter the doctor department: ");
                            String doctorDepartment = in.nextLine();
                            Doctor doctor = new Doctor(doctorName, doctorAge, enums.HospitalDepartments.Neurology , enums.DoctorSpecialize.Doctor);
                            hospitalServices.addDoctor(doctor);
                            break;
                        case (2):
                            if (hospitalServices.getDoctors().isEmpty()) {
                                System.out.println("There are no doctors to be removed\n");
                            } else {
                                System.out.println("Enter ID for the doctor that will be removed: ");
                                int removeID = in.nextInt();
                                hospitalServices.removeDoctor(removeID);
                            }
                            break;
                        case (3):
                            hospitalServices.getDoctorInfo(2000);
                            break;
                        case (4):
                            System.out.println("Enter doctor ID: \n");
                            int DrID = in.nextInt();
                            in.nextLine();
                            Doctor doctorr = hospitalServices.findDoctor(DrID);
                            if (doctorr != null)
                                doctorr.getPatientsOfDoc();
                            else
                                System.out.println("There is no doctor with this ID");
                            break;
                        case (5):
                            hospitalServices.getAllDoctorsInfo();
                            break;
                        case (6):
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;


                    }
                    break;
                case (3):
                    nurseMenu();
                    System.out.println("Enter option number: ");
                    int nurseOption = in.nextInt();
                    in.nextLine();
                    switch (nurseOption) {
                        case (1):
                            System.out.println("Enter the nurse name: ");
                            String nurseName = in.nextLine();
                            System.out.println("Enter the nurse age: ");
                            int nurseAge = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter the nurse department: ");
                            String nurseDepartment = in.nextLine();
                            Nurse nurse = new Nurse(nurseName, nurseAge, nurseDepartment);
                            hospitalServices.addNurse(nurse);
                            break;
                        case (2):
                            if (hospitalServices.getNurses().isEmpty()) {
                                System.out.println("There are no nurses to be removed\n");
                            } else {
                                System.out.println("Enter ID for the nurse that will be removed: ");
                                int removeID = in.nextInt();
                                hospitalServices.removeNurse(removeID);
                            }
                            break;
                        case (3):
                            hospitalServices.getNurseInfo(2000);
                            break;
                        case (4):
                            System.out.println("Enter nurse ID: \n");
                            int NrID = in.nextInt();
                            in.nextLine();
                            Nurse nurse1 = hospitalServices.findNurse(NrID);
                            if (nurse1 != null)
                                nurse1.showPatientsOfNurse();
                            else
                                System.out.println("There is no nurse with this ID\n");
                            break;
                        case (5):
                            hospitalServices.getAllNursesInfo();
                            break;
                        case (6):
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;

                    }
                    break;
                case (4):
                    roomMenu();
                    System.out.println("Enter option number: ");
                    int roomOption = in.nextInt();
                    in.nextLine();
                    switch (roomOption) {
                        case (1):
                            System.out.println("Enter room number: ");
                            int roomNumber = in.nextInt();
                            System.out.println("Enter room capacity: ");
                            int capacity = in.nextInt();
                            in.nextLine();
                            System.out.println("Enter room statue(private or standard): ");
                            String statue = in.next();
                            hospital.Room room = new hospital.Room(roomNumber, capacity, statue);
                            hospitalServices.addRoom(room);
                            break;
                        case (2):
                            if (hospitalServices.getRooms().isEmpty()) {
                                System.out.println("There are no rooms to be removed\n");
                            } else {
                                System.out.println("Enter ID for the room that will be removed: ");
                                int removeID = in.nextInt();
                                hospitalServices.removeRoom(removeID);
                            }
                            break;
                        case (3):
                            hospitalServices.getRoomInfo(2000);
                            break;
                        case (4):
                            System.out.println("Enter room number: \n");
                            int roomNum = in.nextInt();
                            in.nextLine();
                            hospital.Room room1 = hospitalServices.findRoom(roomNum);
                            if (room1 != null)
                                room1.showPatientsInRoom();
                            else
                                System.out.println("There is no room with this ID");

                            break;
                        case (5):
                            hospitalServices.getAllRoomsInfo();
                            break;
                        case (6):
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }
                    break;
                case (5):
                    return;
                default:
                    System.out.println("Invalid option\n");
                    break;
            }
        }
    }
}

