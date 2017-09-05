package at.denton.ejb.repository;

import at.denton.ejb.entity.company.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author mczirfusz
 */
public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    
}