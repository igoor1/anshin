package fatec.anshinpet.domain.exception;

public class MedicationNotFoundException extends ResourceNotFoundException {

    public MedicationNotFoundException(String message) {
        super(message);
    }
}
