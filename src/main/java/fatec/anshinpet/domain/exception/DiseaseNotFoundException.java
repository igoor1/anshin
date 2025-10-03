package fatec.anshinpet.domain.exception;

public class DiseaseNotFoundException extends ResourceNotFoundException {

    public DiseaseNotFoundException(String message) {
        super(message);
    }

}
