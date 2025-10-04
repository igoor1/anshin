package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.AnimalDisease;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalDiseaseRepository extends JpaRepository<AnimalDisease, Long> {

    List<AnimalDisease> findByAnimalId(Long id);
}
