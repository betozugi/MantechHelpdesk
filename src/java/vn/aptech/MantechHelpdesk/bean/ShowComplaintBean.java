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

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class ShowComplaintBean {
    private Complaint complaint;
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
        System.out.println("-------"+c.getIdUser());
        if(EventManager.getInstance().updateComplaint(c.getIdUser())!=null){
            
        }
           
    }
    
}
