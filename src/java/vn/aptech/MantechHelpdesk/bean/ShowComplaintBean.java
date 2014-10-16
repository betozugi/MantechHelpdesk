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
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class ShowComplaintBean {
    private Complaint complaint;
    private Technician technician =new Technician();
    
    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }
    public  ShowComplaintBean(){
        complaint= new Complaint();
    }

    
    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    public List<Complaint> findNewComplaint(){
        return EventManager.getInstance().findNewComplaint();
    }
    public List<Complaint> findHistoryComplaint(){
        return EventManager.getInstance().findHistoryComplaint();
    }
    public void updateComplaint(Complaint c){
         c.setTechnician(technician);
        c.setStatus("1");
        if(EventManager.getInstance().updateComplaint(c)){
            HttpUtils.putToSession("idUser", c);
            HttpUtils.addSuccessMessgae("Success", "Update successfully.");
        }
        else{
            HttpUtils.addErrorMessgae("Error", "Update not success!");
        }
           
    }
    
}
