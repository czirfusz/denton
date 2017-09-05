package at.denton.ejb.repository;

import at.denton.ejb.entity.company.Location;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mczirfusz
 */
public interface LocationRepository extends JpaRepository<Location, Integer> {
    
}
