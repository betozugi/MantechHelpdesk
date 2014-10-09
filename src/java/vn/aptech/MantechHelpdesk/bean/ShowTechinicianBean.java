/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.entities.Technician;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class ShowTechinicianBean {
    private Technician technician;
    public ShowTechinicianBean(){
        technician= new Technician();
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
    public List<Technician> getFreeTechnician(){
        return EventManager.getInstance().getFreeTechnician();
    }
}
