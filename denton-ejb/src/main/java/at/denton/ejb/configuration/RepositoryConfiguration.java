package at.denton.ejb.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.jta.JtaTransactionManager;

/**
 *
 * @author mczirfusz
 */
@Configuration
@EnableJpaRepositories(basePackages = "at.denton.ejb.repository",
        entityManagerFactoryRef = "dentonEntityManager",
        transactionManagerRef = "jtaTransactionManager")
public class RepositoryConfiguration {

    private static final String DENTON_PERSISTENCE_UNIT_NAME = "denton";
    
    @Bean(name = "jtaTransactionManager")
    protected PlatformTransactionManager jtaTransactionManager() {
        return new JtaTransactionManager();
    }
    
    /**
     * Configuration can also be found in persistence.xml
     * @return 
     */
    @Bean(name = "dentonEntityManager")
    public LocalContainerEntityManagerFactoryBean dentonEntityManager() {

        LocalContainerEntityManagerFactoryBean entityManager = new LocalContainerEntityManagerFactoryBean();
        entityManager.setPersistenceUnitName(DENTON_PERSISTENCE_UNIT_NAME);
        entityManager.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return entityManager;

    }

}
