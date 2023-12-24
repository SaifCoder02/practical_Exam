package people;

import enums.DoctorSpecialize;
import enums.HospitalDepartments;
import hospital.Medicine;
import hospital.MedicineNotFoundException;
import hospital.Treatment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Doctor extends Person {

    private Map<Doctor, Patient> doctorToPatient = new HashMap<>();
    private List<Patient> patientsOfDoctor = new ArrayList<>();
    private HospitalDepartments hospitalDepartment;
    private DoctorSpecialize doctorSpecialize;


    public Doctor(String name, int age, HospitalDepartments hospitalDepartment, DoctorSpecialize doctorSpecialize) {
        super(name, age);
        this.doctorSpecialize = doctorSpecialize;
        this.hospitalDepartment = hospitalDepartment;
    }

    public Treatment writeTreatment(LocalDate date, List<Medicine> medicineList, Integer patientId, String patientName) throws MedicineNotFoundException {
        return new Treatment(patientName, patientId, medicineList, date, getName());
    }

    public HospitalDepartments getHospitalDepartment() {
        return hospitalDepartment;
    }

    public DoctorSpecialize getDoctorSpecialize() {
        return doctorSpecialize;
    }

    public void assignDoctorToPatient(Patient patient, Doctor doctor) {
        doctorToPatient.put(doctor, patient);
    }


    public void addPatientToList(Patient patient) {
        patientsOfDoctor.add(patient);
    }

    public void getPatientsOfDoc() {
        if (patientsOfDoctor.isEmpty()) {
            System.out.println("This doctor does not treat any patients");
        } else {
            for (Patient patient : patientsOfDoctor) {
                System.out.println(patient);
            }
        }
    }


    @Override
    public String toString() {
        return "people.Doctor{" +
                "name='" + getName() + '\'' +
                ", Department='" + hospitalDepartment + '\'' +
                ", age= " + getAge() +
                ", ID= " + getID() +
                '}';
    }
}