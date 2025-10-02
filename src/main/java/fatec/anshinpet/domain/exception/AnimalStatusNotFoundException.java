package fatec.anshinpet.domain.exception;

public class AnimalStatusNotFoundException extends ResourceNotFoundException {

    public AnimalStatusNotFoundException(String message) {
        super(message);
    }
}
