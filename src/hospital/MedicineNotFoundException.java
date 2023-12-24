package hospital;

public class MedicineNotFoundException extends Throwable {
    public MedicineNotFoundException(String message) {
        super(message);
    }
}
