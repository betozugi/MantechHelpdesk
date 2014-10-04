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
    }
    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }
    public String login(){
        if(EventManager.getInstance().checkUser(admin) != null)
            return "Admin_Mantech_Helpdesk/index.xhtml";
        return null;
    }
}
