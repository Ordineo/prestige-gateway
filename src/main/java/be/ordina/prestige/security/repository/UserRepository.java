package be.ordina.prestige.security.repository;

import be.ordina.prestige.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by JoLe on 25/01/2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
