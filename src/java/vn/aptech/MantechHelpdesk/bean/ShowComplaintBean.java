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
import javax.faces.bean.ViewScoped;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.business.FeedbackManager;
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
@ViewScoped
public class ShowComplaintBean {
    private Complaint complaint;
    private Technician technician;
    private Feedback feedback;
    private Member mem=new Member();
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
    public List<Complaint> findComplainting(){
        return EventManager.getInstance().findComplainting();
    }
    public List<Complaint> findHistoryComplaint(){
        return EventManager.getInstance().findHistoryComplaint();
    }
    public  List<Complaint> findTechComplaint(){
        technician = (Technician) HttpUtils.getFromSession("tech");
        return EventManager.getInstance().findTechComplaint(technician);
        
    }
    public List<Complaint> findTechComplaiting(){
        technician = (Technician) HttpUtils.getFromSession("tech");
        return EventManager.getInstance().findTechComplainting(technician); 
    }
    public void completed(Complaint c){
        if(EventManager.getInstance().completed(c)){
            HttpUtils.addSuccessMessgae("Success", "Update successfully.");
        }
        else{
            HttpUtils.addErrorMessgae("Error", "Update not success!");
        }
        
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
    public String sendFeedback(Complaint c){
        feedback.setComplaint(c);
        admin = (Admin) HttpUtils.getFromSession("admin");
        feedback.setAdmin(admin);
        if(EventManager.getInstance().insertFeedback(feedback)){
                 HttpUtils.addSuccessMessgae("Success", "Send feedback successfully.");
                 return "HistoryComplaints";
        }
        else
        {
            HttpUtils.addErrorMessgae("Error", "Send feedback not success!");
            return null;
        }
        
        
    }
    public List<Feedback> feedbackMemberShow(Complaint c){
            complaint=FeedbackManager.getInstance().findByIdMember(c);
//        System.out.println(complaint.getId()+"    lalalallalalalal id" + complaint.getMember().getId());
        return FeedbackManager.getInstance().feedbackMemberShow(complaint.getMember().getId(),complaint.getId());
//        return FeedbackManager.getInstance().feedbackMemberShow();
    }
    public List<Feedback> feedbackAdminShow(Complaint c){
        complaint=FeedbackManager.getInstance().findByIdMember(c);
        System.out.print(complaint.getId());
        return FeedbackManager.getInstance().feedbackAdminShow(complaint.getId());
    }
    
}
