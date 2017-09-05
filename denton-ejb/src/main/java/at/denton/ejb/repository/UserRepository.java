package at.denton.ejb.repository;

import at.denton.ejb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mczirfusz
 */
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
