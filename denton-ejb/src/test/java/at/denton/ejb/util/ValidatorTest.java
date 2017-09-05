package at.denton.ejb.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

/**
 *
 * @author mczirfusz
 */
@RunWith(MockitoJUnitRunner.class)
public class ValidatorTest {
    
    @InjectMocks
    private Validator validator;
    
    @Test
    public void shouldMatchAValidMailAddress() {
        
        /*ARRANGE*/
        String mailAddress = "Firstname.Last-name2@sub-domain1_domain.tld";
        
        /*ACT*/
        boolean result = validator.isValidMailAddress(mailAddress);
        
        /*ASSERT*/
        assertTrue(result);
        
    }
    
}
