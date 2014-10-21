/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import static java.util.Collections.list;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.MemberEventManager;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Feedback;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class HistoryComplaintBean {
    private Complaint complaint;
    
    public HistoryComplaintBean(){
        complaint= new Complaint();
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
    public List<Complaint> getListComplaint(String id){
        return MemberEventManager.getInstance().getListComplaint(id);
    }
    public String getIdComplaint(){
        if(MemberEventManager.getInstance().getIdComplaint(complaint)!=null){
//            System.out.println(complaint.getId());
          
            return "/Member_Mantech_Helpdesk/Feedback.xhtml";
        }else{
            return null;
        }
    }
    public List<Feedback> findByIdFeedback(Feedback f){
        return MemberEventManager.getInstance().findByIdFeedback(f.getComplaint().getId());
        
    }
    
    
    public  List<Feedback> getListFeedback() {
        List<Feedback> list= MemberEventManager.getInstance().findByIdFeedback(complaint.getId());
        return list;
        
    }
}
