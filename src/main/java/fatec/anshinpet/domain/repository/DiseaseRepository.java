package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Disease;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {

}
