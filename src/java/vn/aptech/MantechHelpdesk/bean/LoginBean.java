/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.entities.Admin;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author Beto
 */
@ManagedBean
@RequestScoped
public class LoginBean {
    private Admin admin=new Admin();

    public LoginBean(){
        admin.setAdname("admin");
        admin.setAdpass("123456");
    }
    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public String login(){
        if(EventManager.getInstance().checkAdmin(admin) != null){
            HttpUtils.putToSession("admin", admin.getAdname());
            HttpUtils.putToSession("avatar", admin.getAvatar());
            
            return "/Admin_Mantech_Helpdesk/Index.xhtml";
            
        }
        else{
             HttpUtils.addErrorMessgae("Error", "Username or Password not correct.");
        return  null;
        }
    }
    
     
    public String getUrl(){
       return  HttpUtils.getFullURL();
    }
    public String getSession(){
        return  String.valueOf(HttpUtils.getFromSession("admin"));
    }
    
    public boolean isLogined(){
        if(HttpUtils.getFromSession("admin")!=null){
            return true;
        }
        return false;
        
    }
}
