package at.denton.web.session;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mczirfusz
 */
public class SessionPropertyTest {
    
    @Test
    public void shouldMatchAMobileUserAgent() {
        
        /*ARRANGE*/
        String userAgent = "Brower Mobile Safari version X";
        
        /*ACT*/
        boolean result = SessionProperty.isMobileAgent(userAgent);
        
        /*ASSERT*/
        assertTrue(result);
        
    }
    
    @Test
    public void shouldNotMatchAMobileUserAgent() {
        
        /*ARRANGE*/
        String userAgent = "Brower Mozilla Firefox version X";
        
        /*ACT*/
        boolean result = SessionProperty.isMobileAgent(userAgent);
        
        /*ASSERT*/
        assertFalse(result);
        
    }
    
    @Test
    public void shouldNotMatchAMobileUserAgentWhenNull() {
        
        /*ARRANGE*/
        String userAgent = null;
        
        /*ACT*/
        boolean result = SessionProperty.isMobileAgent(userAgent);
        
        /*ASSERT*/
        assertFalse(result);
        
    }
    
}
