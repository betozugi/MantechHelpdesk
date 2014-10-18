/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.AccountManager;
import vn.aptech.MantechHelpdesk.entities.Member;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@RequestScoped
public class AccountManagerBean {
    private Member member;
    public AccountManagerBean(){
        member= new Member();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
    
    public List<Member> getListMember(){
        return AccountManager.getInstance().getListMember();
    }
    public String getIdMember(){
        if(AccountManager.getInstance().getIdMember(member)!=null){
            return "/Admin_Mantech_Helpdesk/UpdateMember.xhtml";
        }else{
            return null;
        }
    }
    public String updateMember(){
        if(AccountManager.getInstance().updateMember(member)!=false){
            return "/Admin_Mantech_Helpdesk/AccountManager.xhtml";
        }else{
            return null;
        }
    }
}
