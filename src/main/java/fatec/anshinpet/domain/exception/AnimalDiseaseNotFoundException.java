package fatec.anshinpet.domain.exception;

public class AnimalDiseaseNotFoundException extends ResourceNotFoundException {

    public AnimalDiseaseNotFoundException(String message) {
        super(message);
    }
}
