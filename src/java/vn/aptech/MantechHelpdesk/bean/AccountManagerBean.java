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
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.hibernate.Query;
import org.hibernate.Session;
import vn.aptech.MantechHelpdesk.business.AccountManager;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HibernateUtil;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@SessionScoped
public class AccountManagerBean {
    private Member member =new Member();
    
    
    
    public AccountManagerBean(){
//        member= new Member();
        System.out.println(" AccountManagerBean()");
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
        System.out.println(".......................................................................");
        System.out.println(member.getId());
        if(AccountManager.getInstance().updateMember(member)==true){
            HttpUtils.addSuccessMessgae("Success", "Edit account successfully.");
            return "/Admin_Mantech_Helpdesk/AccountManager";
        }else{
            HttpUtils.addErrorMessgae("Error", "Edit member error!");
            return null;
        }
    }
    @FacesConverter(forClass = Member.class)
    public class MemberConverter implements Converter{

        @Override
        public Object getAsObject(FacesContext fc, UIComponent uic, String pk) {
                return AccountManager.getInstance().findIdMember(Integer.valueOf(pk));
             }

        @Override
        public String getAsString(FacesContext fc, UIComponent uic, Object o) {
            return ""+ ((Member)o).getId();
        }

        public MemberConverter() {
        }
        
        
    }
     
}
