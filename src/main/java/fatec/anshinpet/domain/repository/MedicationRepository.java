package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
