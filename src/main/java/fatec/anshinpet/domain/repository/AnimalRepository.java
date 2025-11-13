package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Animal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query("SELECT a FROM Animal a WHERE a.animalStatus.id = 6")
    Page<Animal> findAvailableForAdoption(Pageable pageable);
}
