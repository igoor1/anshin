package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {

}
