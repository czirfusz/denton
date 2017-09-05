package at.denton.drcaspary.controller;

import at.denton.web.session.SessionProperty;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.inputtextarea.InputTextarea;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="ratingBean" )
@RequestScoped
public class RatingController {
    
    private InputTextarea ratingText;
    
    @PostConstruct
    public void init ( ) {
        
        ratingText =  new InputTextarea();
        if (SessionProperty.getFacesSessionAttribute(SessionProperty.SESSION_KEY_USER_ID) == null) {
            ratingText.setDisabled(true);
        }
        
    }

    // getters and setters
    public InputTextarea getRatingText() {
        return ratingText;
    }

    public void setRatingText(InputTextarea ratingText) {
        this.ratingText = ratingText;
    }
    
}
