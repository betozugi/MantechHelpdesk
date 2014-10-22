/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.aptech.MantechHelpdesk.bean;

import java.time.Clock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import vn.aptech.MantechHelpdesk.business.MemberEventManager;
import vn.aptech.MantechHelpdesk.entities.Complaint;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.entities.Technician;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author ngocyen
 */
@ManagedBean
@SessionScoped
public class MemberLoginBean {
    private Member member;
    private Technician tech;

    public Technician getTech() {
        return tech;
    }

    public void setTech(Technician tech) {
        this.tech = tech;
    }
    public MemberLoginBean(){
        member= new Member();
        tech =new Technician();
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    
    public String getUser(){
        member= MemberEventManager.getInstance().getUser(member);
        if(member!=null){
            HttpUtils.putToSession("User", member);
//            System.out.println(member.getAvatar());
            return "/Member_Mantech_Helpdesk/Home.xhtml";
        }
        else{
            HttpUtils.addErrorMessgae("error", "Username or password incorrect");
            return null;
        }
    }
    public String getLoginTechnician(){
        tech= MemberEventManager.getInstance().getTech(tech);
        if(tech!=null){
            HttpUtils.putToSession("tech", tech);
//            System.out.println(member.getAvatar());
            return "/Member_Mantech_Helpdesk/Technician";
        }
        else{
            HttpUtils.addErrorMessgae("error", "Username or password incorrect");
            return null;
        }
    }
//    public List<Member> getListMember(){
//        return MemberEventManager.getInstance().getListMember(member);
//    }
    public String getUrl(){
        return HttpUtils.getFullURL();
    }
    public Member getSession(){
         Member m= new Member();
            m= (Member)HttpUtils.getFromSession("User");
            return m;
    }
    public boolean isLogined(){
        if(HttpUtils.getFromSession("User")!=null){
            return true;
        }
        return false;
        
    }
    public String Logout(){
        HttpUtils.putToSession("User", null);
        return "/Index"; 
    }
}
