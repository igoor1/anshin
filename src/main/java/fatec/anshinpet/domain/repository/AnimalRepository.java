package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

}
