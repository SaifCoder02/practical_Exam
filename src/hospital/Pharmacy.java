package hospital;

import enums.DoctorSpecialize;
import people.Doctor;

import java.util.List;

public class Pharmacy {
    private static List<Medicine> medicineList;
    private List<Doctor> doctorList;

    public Pharmacy(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public static Boolean isMedicineAvailable(Medicine medicine) {
        return medicineList.contains(medicine);
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void addPharmacist(Doctor... doctors) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorSpecialize() != DoctorSpecialize.Pharmacist) {
                throw new IllegalArgumentException("Doctor must be a pharmacist");
            } else doctorList.add(doctor);
        }
    }

    public void addMedicine(Medicine medicine) {
        medicineList.add(medicine);
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "doctorList=" + doctorList +
                '}';
    }
}
