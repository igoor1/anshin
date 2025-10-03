package fatec.anshinpet.domain.exception;

public class VaccineNotFoundException extends RuntimeException {
    public VaccineNotFoundException(String message) {
        super(message);
    }
}
