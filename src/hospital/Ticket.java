package hospital;

import enums.HospitalDepartments;
import people.Patient;

public class Ticket {
    private String date;
    private HospitalDepartments department;
    private static Integer ticketId = 0;
    private Patient patient;

    public Ticket(String date, HospitalDepartments department , Patient patient) {
        this.patient = patient;
        this.date = date;
        ticketId += 1;
        this.department = department;
    }


    public static Integer getTicketId() {
        return ticketId;
    }

    public String getDay() {
        return date;
    }

    public HospitalDepartments getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "date='" + date + '\'' +
                ", department=" + department +
                ", patient=" + patient +
                '}';
    }
}
