package at.denton.ejb.util.mobile;

import javax.ejb.Stateless;

/**
 *
 * @author mczirfusz
 */
@Stateless
public class Msisdn {
    
    private static final String EMPTY_STRING = "";
    
    public String normalizePhoneNumber(final String number) {
        try {
            return Long.toString( Long.parseLong(number.trim().replaceAll("\\D", EMPTY_STRING)) );
        } catch (NullPointerException npe) {
            throw new IllegalArgumentException("Phone number must not be null!", npe);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("Phone number must not be empty and must contain numbers only", nfe);
        }
    }
    
}
