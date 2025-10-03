package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.AnimalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalStatusRepository extends JpaRepository<AnimalStatus, Long> {
}
