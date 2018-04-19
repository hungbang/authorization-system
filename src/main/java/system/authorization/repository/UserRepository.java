package system.authorization.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import system.authorization.domain.User;

import java.util.Optional;

/**
 * Created by KAI on 4/16/18.
 */
public interface UserRepository extends JpaRepository<User, String>{

    User findByUsername(String s);

}
