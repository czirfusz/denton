package at.denton.drcaspary.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.component.dialog.Dialog;
import org.primefaces.component.notificationbar.NotificationBar;
import org.primefaces.component.menuitem.UIMenuItem;

/**
 *
 * @author mczirfusz
 */
@ManagedBean ( name="indexBean" )
@ViewScoped
public class IndexController {
    
    // view components
    private NotificationBar ordinationTimes;
    private UIMenuItem timeMenuItem;
    private Dialog serviceDialog;
    private Dialog processDialog;
    
    public void openServiceDialog ( ) {
        this.serviceDialog.setVisible ( true );
    }
    
    public void closeServiceDialog ( ) {
        this.serviceDialog.setVisible ( false );
    }
    
    public void closeProcessDialog ( ) {
        this.processDialog.setVisible ( false );
    }

    private void showOrdinationTimes ( ) {
        this.ordinationTimes.setAutoDisplay ( true );
    }
    
    private void hideOrdinationTimes ( ) {
        this.ordinationTimes.setAutoDisplay ( false );
    }
    
    public void showHideOrdinationTimes ( ) {
        if ( ! this.ordinationTimes.isAutoDisplay() ) {
            timeMenuItem.setValue ( "Ordinationszeiten ausblenden" );
            showOrdinationTimes ( );
        } else {
            timeMenuItem.setValue ( "Ordinationszeiten anzeigen" );
            hideOrdinationTimes ( );
        }
    }

    // getters and setters
    public NotificationBar getOrdinationTimes() {
        return ordinationTimes;
    }

    public void setOrdinationTimes(final NotificationBar ordinationTimes) {
        this.ordinationTimes = ordinationTimes;
    }

    public Dialog getServiceDialog() {
        return serviceDialog;
    }

    public void setServiceDialog(final Dialog serviceDialog) {
        this.serviceDialog = serviceDialog;
    }

    public Dialog getProcessDialog() {
        return processDialog;
    }

    public void setProcessDialog(final Dialog processDialog) {
        this.processDialog = processDialog;
    }

    public UIMenuItem getTimeMenuItem() {
        return timeMenuItem;
    }

    public void setTimeMenuItem(final UIMenuItem timeMenuItem) {
        this.timeMenuItem = timeMenuItem;
    }

}