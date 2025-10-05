package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.AnimalMedication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalMedicationRepository extends JpaRepository<AnimalMedication, Long> {

    List<AnimalMedication> findByAnimalId(Long id);
}
