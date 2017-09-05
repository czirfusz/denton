package at.denton.drcaspary.controller.model;

import at.denton.drcaspary.controller.data.DataBean;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="mapBean" )
@RequestScoped
public class MapBean {
    
    @ManagedProperty ( value="#{dataBean}" )
    private DataBean dataBean;
    
    // view components
    private Dialog mapDialog;
    
    private MapModel mapModel;
    private Marker marker;
    private static final double LAT = 48.192008;
    private static final double LNG = 16.340397;
    
    @PostConstruct
    public void init ( ) {
        mapModel = new DefaultMapModel();
        LatLng coordinates = new LatLng( LAT, LNG );
        marker = new Marker ( coordinates );
        marker.setIcon ( dataBean.getMarkerPath() );
        mapModel.addOverlay ( marker );
    }
    
    public void openMapDialog ( ) {
        this.mapDialog.setVisible ( true );
    }
    
    public void closeMapDialog ( ) {
        this.mapDialog.setVisible ( false );
    }

    // getters and setters
    public MapModel getMapModel() {
        return mapModel;
    }

    public Marker getMarker() {
        return marker;
    }

    public double getLat() {
        return LAT;
    }

    public double getLng() {
        return LNG;
    }

    public Dialog getMapDialog() {
        return mapDialog;
    }

    public void setMapDialog(final Dialog mapDialog) {
        this.mapDialog = mapDialog;
    }

    public DataBean getDataBean() {
        return dataBean;
    }

    public void setDataBean(final DataBean dataBean) {
        this.dataBean = dataBean;
    }
    
}
