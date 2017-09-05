package at.denton.drcaspary.controller.data;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="dataBean" )
@SessionScoped
public class DataBean {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(DataBean.class);
    
    private String markerPath;
    
    @PostConstruct
    public void init ( ) {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = request.getRequestURL().toString().replaceAll(request.getServletPath(), "");
        LOGGER.info ( String.format("Request URL: %s", url) );
        setMarkerPath ( url + "/view/image/marker.png" );
    }

    public String getMarkerPath() {
        return markerPath;
    }

    public void setMarkerPath(final String markerPath) {
        this.markerPath = markerPath;
    }
    
}
