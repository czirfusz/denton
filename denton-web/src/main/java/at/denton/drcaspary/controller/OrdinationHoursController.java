package at.denton.drcaspary.controller;

import at.denton.drcaspary.controller.bean.OrdinationHoursBean;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="ordinationHoursBean" )
@RequestScoped
public class OrdinationHoursController {
    
    private List<OrdinationHoursBean> ordinationHoursList;
    
    @PostConstruct
    public void init ( ) {
        
        ordinationHoursList = new ArrayList<OrdinationHoursBean>();
        ordinationHoursList.add ( new OrdinationHoursBean("Montag", "9:00", "18:00", null) );
        ordinationHoursList.add ( new OrdinationHoursBean("Dienstag", "9:00", "18:00", null) );
        ordinationHoursList.add ( new OrdinationHoursBean("Mittwoch", "9:00", "12:00", null) );
        ordinationHoursList.add ( new OrdinationHoursBean("Donnerstag", "8:00", "17:00", null) );
        ordinationHoursList.add ( new OrdinationHoursBean("Freitag", "9:00", "12:00", null) );
        
    }

    // getters and setters
    public List<OrdinationHoursBean> getOrdinationHoursList() {
        return ordinationHoursList;
    }

    public void setOrdinationHoursList(final List<OrdinationHoursBean> ordinationHoursList) {
        this.ordinationHoursList = ordinationHoursList;
    }
    
}
