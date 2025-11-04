package fatec.anshinpet.domain.exception;

public class DonationNotFoundException extends ResourceNotFoundException {

    public DonationNotFoundException(String message) {
        super(message);
    }
}
