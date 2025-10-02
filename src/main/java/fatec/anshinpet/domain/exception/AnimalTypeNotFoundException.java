package fatec.anshinpet.domain.exception;

public class AnimalTypeNotFoundException extends ResourceNotFoundException {

    public AnimalTypeNotFoundException(String message) {
        super(message);
    }
}
