package at.denton.ejb.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.ejb.Stateless;

/**
 *
 * @author mczirfusz
 */
@Stateless
public class Validator {
    
    private static final String VALID_MAIL_ADDRESS_REGEX = "^[a-z|A-Z]+([\\.|\\-\\_]?[a-z|A-Z|0-9]+)+[@][a-z|A-Z]+([\\.|\\-\\_]?[a-z|A-Z|0-9]+)+[\\.][a-z|A-Z]{2,4}";
    
    private boolean regexMatches(final String regexPattern, final String string) {
        
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(string);
        
        return matcher.matches();
    }
    
    public boolean isValidMailAddress(final String mailAddress) {
        return regexMatches(VALID_MAIL_ADDRESS_REGEX, mailAddress);
    }
    
}