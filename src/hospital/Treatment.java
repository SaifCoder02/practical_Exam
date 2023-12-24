package hospital;

import java.time.LocalDate;
import java.util.List;

public class Treatment {
    private String patientName;
    private Integer patientId;
    private List<Medicine> medicineList;
    private LocalDate date;
    private String doctorName;

    public Treatment(String patientName, Integer patientId, List<Medicine> medicineList, LocalDate date, String doctorName) throws MedicineNotFoundException {
        this.patientName = patientName;
        this.patientId = patientId;
        for (Medicine medicine : medicineList) {
            if (!Pharmacy.isMedicineAvailable(medicine)) throw new MedicineNotFoundException(medicine.getName()+" is not available");
        }
        this.medicineList = medicineList;
        this.date = date;
        this.doctorName = doctorName;
    }

    public String getPatientName() {
        return patientName;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDoctorName() {
        return doctorName;
    }

}
