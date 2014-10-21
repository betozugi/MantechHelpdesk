/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import vn.aptech.MantechHelpdesk.business.FeedbackManager;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@SessionScoped
public class FeedbackMemberBean {
     private Feedback feedback;
    private Member member;
    private Complaint complaint;
      public FeedbackMemberBean(){
         feedback= new Feedback();
         member= new Member();
         complaint= new Complaint();
     }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
      
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
   
    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }
    public String sendFeedbackMember(Complaint c){
            member= (Member)HttpUtils.getFromSession("User");
            feedback.setMember(member);
           complaint= c;
           feedback.setComplaint(complaint);
        if(FeedbackManager.getInstance().sendFeedback(feedback)){
          HttpUtils.addSuccessMessgae("Success", "Send mail successfully!");
          return "/Member_Mantech_Helpdesk/HistoryComplains.xhtml";
        }
        else{
             HttpUtils.addErrorMessgae("Error", "Send mail fail.");
             return null;
        }
         
        
    }
}
