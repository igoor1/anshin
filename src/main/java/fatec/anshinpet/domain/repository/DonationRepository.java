package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Donation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationRepository extends JpaRepository<Donation, Long> {

}
