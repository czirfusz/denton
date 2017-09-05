package at.denton.web.session;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mczirfusz
 */
public class RedirectHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedirectHandler.class);

    private static final String REQUEST_HEADER_KEY_X_REQUESTED_WITH = "X-Requested-With";
    private static final String REQUEST_HEADER_VALUE_X_REQUESTED_WITH = "XMLHttpRequest";
    public static final char QUESTION = '?';
    public static final char EQUAL = '=';
    public static final char AND = '&';

    private final HttpServletRequest request;
    private final HttpServletResponse response;
    private final String redirectURL;
    
    public RedirectHandler(final HttpServletRequest request, final HttpServletResponse response, final String redirectURL) {
        this.request = request;
        this.response = response;
        this.redirectURL = redirectURL;
    }

    public void redirect() throws IOException {
        LOGGER.info("Redirect to: {}", this.redirectURL);
        if (isAjaxRequest()) {
            LOGGER.info("We have an AJAX request!");
            doFacesRedirect();
        } else {
            this.response.sendRedirect(this.redirectURL);
        }
    }
    
    public void doFacesRedirect() throws IOException {
        getFacesContext().getExternalContext().redirect(this.redirectURL);
    }

    private FacesContext getFacesContext() {
        FacesContext facesContext = FacesContext.getCurrentInstance();

        if (facesContext == null) {

            LifecycleFactory lifecycleFactory
                    = (LifecycleFactory) FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

            FacesContextFactory contextFactory
                    = (FacesContextFactory) FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            facesContext
                    = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response,
                            lifecycle);

            UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "");
            facesContext.setViewRoot(view);
        }

        return facesContext;
    }

    private boolean isAjaxRequest() {
        if (request.getHeader(REQUEST_HEADER_KEY_X_REQUESTED_WITH) != null
                && request.getHeader(REQUEST_HEADER_KEY_X_REQUESTED_WITH).equals(REQUEST_HEADER_VALUE_X_REQUESTED_WITH)) {
            return true;
        }

        return false;

    }

}
