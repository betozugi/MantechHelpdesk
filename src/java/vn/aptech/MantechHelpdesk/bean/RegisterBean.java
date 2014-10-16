/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package vn.aptech.MantechHelpdesk.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;
import vn.aptech.MantechHelpdesk.business.EventManager;
import vn.aptech.MantechHelpdesk.entities.Member;
import vn.aptech.MantechHelpdesk.util.HttpUtils;

/**
 *
 * @author Beto
 */
@ManagedBean
@RequestScoped
public class RegisterBean {
    private Member member=new Member();
    
     public RegisterBean(){
        member.setPassword("123456");
    }
    public Member getMember() {
        return member;
    }
   
    public void setMember(Member member) {
        this.member = member;
    }
    public String insertMember(){
        member.setAvatar("1.jpg");
        if(EventManager.getInstance().insertMember(member))
        {
            HttpUtils.addSuccessMessgae("Success", "Create new member successfully!");
        }
        else{
            HttpUtils.addErrorMessgae("Error", "Create new member fail.");
        }
        
        return null;
        
    }
    public void validateFile(FacesContext ctx,
                         UIComponent comp,
                         Object value) {
        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part)value;
        if (file.getSize() > 1024) {
          msgs.add(new FacesMessage("file too big"));
        }
        if (!"text/plain".equals(file.getContentType())) {
          msgs.add(new FacesMessage("not a text file"));
        }
        if (!msgs.isEmpty()) {
          throw new ValidatorException(msgs);
        }
    }
}
