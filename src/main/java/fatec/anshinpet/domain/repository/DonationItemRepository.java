package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.DonationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DonationItemRepository extends JpaRepository<DonationItem, Long> {

}
