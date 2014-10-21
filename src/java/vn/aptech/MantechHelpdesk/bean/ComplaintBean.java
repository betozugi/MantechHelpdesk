/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.swing.JOptionPane;
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
public class ComplaintBean {
    private Complaint complaint;
    private Technician tech;

    public Technician getTech() {
        return tech;
    }

    public void setTech(Technician tech) {
        this.tech = tech;
    }
    public ComplaintBean(){
        complaint= new Complaint();
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    
     public String inserComplaint(){
          Member m= new Member();
            m= (Member)HttpUtils.getFromSession("User");
        complaint.setStatus("0");
        complaint.setMember(m);
        complaint.setIdUser(m.getId());
        complaint.setTechnician(null);
        if(EventManager.getInstance().insertComplaint(complaint))
        {
            HttpUtils.addSuccessMessgae("Success", "Send Complaint successfully!");
        }
        else{
             HttpUtils.addErrorMessgae("Error", "Send complaint fail.");
        }
        
        return null;
        
    }
    
   
}
