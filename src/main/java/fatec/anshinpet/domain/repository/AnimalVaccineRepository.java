package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.AnimalVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnimalVaccineRepository extends JpaRepository<AnimalVaccine, Long> {

    List<AnimalVaccine> findByAnimalId(Long id);
}
