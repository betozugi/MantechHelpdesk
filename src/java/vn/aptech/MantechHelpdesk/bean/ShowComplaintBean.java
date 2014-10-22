/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@SessionScoped
public class ShowComplaintBean {
    private Complaint complaint;
    private Technician technician;
    private Feedback feedback;
    private Admin admin=new Admin();
    public ShowComplaintBean(){
        feedback=new Feedback();
        complaint=new Complaint();
        technician =new Technician();
        
    }
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
    
    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
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
            complaint=c;
            System.out.println(complaint.getId());
            feedback.setComplaint(complaint);
            admin = (Admin) HttpUtils.getFromSession("admin");
            feedback.setAdmin(admin);
            if(EventManager.getInstance().insertFeedback(feedback)){
                 HttpUtils.addSuccessMessgae("Success", "Send feedback successfully.");
            }
            else
            {
                HttpUtils.addErrorMessgae("Error", "Send feedback not success!");
            }
        }
        else{
            HttpUtils.addErrorMessgae("Error", "Update not success!");
        }
           
    }
    public String sendFeedback(){
        if(EventManager.getInstance().insertFeedback(feedback)){
                 HttpUtils.addSuccessMessgae("Success", "Send feedback successfully.");
                 return "HistoryComplains";
            }
            else
            {
                HttpUtils.addErrorMessgae("Error", "Send feedback not success!");
                return null;
            }
        
        
    }
    
}
