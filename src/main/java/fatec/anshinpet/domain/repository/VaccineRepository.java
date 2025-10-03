package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

}
