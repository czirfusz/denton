package at.denton.web.session;

import java.util.Arrays;
import java.util.Optional;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mczirfusz
 */
public class SessionProperty {
    
    private static final String[] MOBILE_DEVICES_ATTRIBUTES = {"android", "iphone", "ipod", "ipad", "blackberry", "mobile safari", "windows phone"};
    public static final String SESSION_KEY_USER_ID = "user_id";
    
    public static boolean isMobileAgent(final String userAgent) {
        
        return Arrays.asList(MOBILE_DEVICES_ATTRIBUTES)
                .stream()
                .anyMatch(deviceAttribute -> userAgent != null && userAgent.toLowerCase().contains(deviceAttribute));
        
    }

    public static Object getFacesSessionAttribute(final String key) {

        return getFacesSession().getAttribute(key);

    }

    public static void setSessionAttribute(String key, Object object) {

        getFacesSession().setAttribute(key, object);

    }
    
    public static boolean isSessionNotAvailable(final HttpServletRequest request) {
        
        return ! Optional.ofNullable(request.getSession(false)).isPresent();
        
    }

    private static HttpSession getFacesSession() {

        return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);

    }

}
