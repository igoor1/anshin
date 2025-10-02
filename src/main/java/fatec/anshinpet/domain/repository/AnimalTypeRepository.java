package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.AnimalType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalTypeRepository extends JpaRepository<AnimalType, Long> {
}
