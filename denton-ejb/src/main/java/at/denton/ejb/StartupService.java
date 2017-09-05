package at.denton.ejb;

import at.denton.ejb.repository.OrganizationRepository;
import java.util.TimeZone;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.interceptor.Interceptors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mczirfusz
 */
@Singleton
@Startup
@Interceptors(SpringBeanAutowiringInterceptor.class)
public class StartupService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartupService.class);
    
    @Autowired
    private OrganizationRepository organizationRepository;

    @PostConstruct
    @Transactional
    public void init() {

        LOGGER.info("Applicaton startup execution...");
        LOGGER.info("Setting time zone to UTC...");
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
        LOGGER.info("First organization name is: {}", organizationRepository.getOne(1).getName());

    }

}