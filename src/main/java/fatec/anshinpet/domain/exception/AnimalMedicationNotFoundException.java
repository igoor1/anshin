package fatec.anshinpet.domain.exception;

public class AnimalMedicationNotFoundException extends ResourceNotFoundException{

    public AnimalMedicationNotFoundException(String message) {
        super(message);
    }
}
