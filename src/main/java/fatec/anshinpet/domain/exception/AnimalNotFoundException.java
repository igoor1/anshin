package fatec.anshinpet.domain.exception;

public class AnimalNotFoundException extends ResourceNotFoundException {

    public AnimalNotFoundException(String message) {
        super(message);
    }

}
