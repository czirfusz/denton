package at.denton.ejb.util.mobile;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author mczirfusz
 */
@RunWith(MockitoJUnitRunner.class)
public class MsisdnTest {
    
    @InjectMocks
    private Msisdn msisdn;
    
    @Test
    public void shouldNormalizePhoneNumberWithLeading0sAndEndingSpace() {
        
        /*ARRANGE*/
        String phoneNumber = "+0066412 34567 ";
        
        /*ACT*/
        String result = msisdn.normalizePhoneNumber(phoneNumber);
        
        /*ASSERT*/
        assertEquals("6641234567", result);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNumberIsNull() {
        
        /*ACT*/
        msisdn.normalizePhoneNumber(null);
        
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionWhenNumberIsEmpty() {
        
        /*ACT*/
        msisdn.normalizePhoneNumber("");
        
    }
    
}
