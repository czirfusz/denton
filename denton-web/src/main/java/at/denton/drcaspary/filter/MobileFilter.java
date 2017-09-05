package at.denton.drcaspary.filter;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mczirfusz
 */
public class MobileFilter implements Filter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MobileFilter.class);
    
    @Override
    public void init ( final FilterConfig config ) {
        
    }
    
    @Override
    public void doFilter ( final ServletRequest req, final ServletResponse res, final FilterChain chain ) {
        
        //logger.info ( "Executing mobile filter... looking up, if request is from a mobile device." );
        
        HttpServletRequest request = (HttpServletRequest) req;
	HttpServletResponse response = (HttpServletResponse) res;
        String userAgent = request.getHeader ( "User-Agent" );
        LOGGER.info ( String.format("Got user agent: %s", userAgent) );
    
        try {
            if ( userAgent != null 
                    && (userAgent.toLowerCase().indexOf("android") != -1 
                    || userAgent.toLowerCase().indexOf("iphone") != -1
                    || userAgent.toLowerCase().indexOf("ipod") != -1
                    || userAgent.toLowerCase().indexOf("ipad") != -1
                    || userAgent.toLowerCase().indexOf("blackberry") != -1
                    || userAgent.toLowerCase().indexOf("mobile safari") != -1
                    || userAgent.toLowerCase().indexOf("windows phone") != -1) ) {
                LOGGER.info ( "redirecting to the mobile page..." );
                response.sendRedirect ( "http://mobile.drcaspary.denton.at" );
            } else {
                chain.doFilter ( req, res );
            }
        } catch ( IOException ioe ) {
            LOGGER.error ( "I/O exception in filter!", ioe );
        } catch ( ServletException se ) {
            LOGGER.error ( "Servlet exception in filter!", se );
        }
        
    }
    
    @Override
    public void destroy ( ) {
        
    }
    
}
