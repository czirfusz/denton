package at.denton.drcaspary.filter;

import at.denton.web.session.SessionProperty;
import java.io.IOException;
import javax.faces.application.ViewExpiredException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mczirfusz
 */
public class AuthorizationFilter implements Filter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizationFilter.class);
    private static final String REDIRECT_TO_MOBILE_PAGE = "http://mobile.drcaspary.denton.at";
    public static final String REDIRECT_TO_MAIN_PAGE = "/view/index.xhtml";
    
    @Override
    public void init ( final FilterConfig config ) {
        
    }
    
    @Override
    public void doFilter ( final ServletRequest req, final ServletResponse res, final FilterChain chain ) {
        
        HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
        String userAgent = request.getHeader ( "User-Agent" );
    
        try {
            
//            if (SessionProperty.isSessionNotAvailable(request)) {
//
//                LOGGER.info ( "No Session available!" );
//                new RedirectHandler(request, response, REDIRECT_TO_MAIN_PAGE).doFacesRedirect();
//
//            }
            
            if ( SessionProperty.isMobileAgent(userAgent) ) {

                LOGGER.info ( "Got user agent: {}", userAgent );
                LOGGER.info ( "redirecting to the mobile page..." );
                response.sendRedirect ( REDIRECT_TO_MOBILE_PAGE );
                
            } else {
                chain.doFilter ( req, res );
            }
        } catch ( IOException ioe ) {
            LOGGER.error ( "I/O exception in filter!", ioe );
        } catch ( ServletException se ) {
            LOGGER.error ( "Servlet exception in filter! {}", se.getRootCause().getMessage() );
            if (se.getRootCause() instanceof ViewExpiredException) {
                throw new ViewExpiredException();
            }
        } catch ( IllegalStateException ise ) {
            LOGGER.info ( "Illegal State Exception! {}", ise.getMessage() );
        }
        
    }
    
    @Override
    public void destroy ( ) {
        
    }

}

