/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.MemberEventManager;
import vn.aptech.MantechHelpdesk.entities.Complaint;

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
}
