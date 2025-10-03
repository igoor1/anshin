package fatec.anshinpet.domain.exception;

public class AnimalVaccineNotFoundException extends ResourceNotFoundException {

    public AnimalVaccineNotFoundException(String message) {
        super(message);
    }
}
