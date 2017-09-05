package at.denton.drcaspary.controller;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="startBean" )
@RequestScoped
public class StartController {
    
    public void loadPage ( ) throws IOException {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        FacesContext.getCurrentInstance().getExternalContext().redirect( request.getContextPath() + "/index.xhtml" );
        
    }
    
}
