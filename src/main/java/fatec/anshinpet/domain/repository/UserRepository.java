package fatec.anshinpet.domain.repository;

import fatec.anshinpet.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.email = :email")
    Optional<User> findUserByEmail(String email);

}
